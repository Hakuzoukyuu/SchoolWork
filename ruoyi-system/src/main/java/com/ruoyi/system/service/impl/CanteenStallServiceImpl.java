package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.CanteenDish;
import com.ruoyi.system.mapper.CanteenStallMapper;
import com.ruoyi.system.domain.CanteenStall;
import com.ruoyi.system.service.ICanteenStallService;
import com.ruoyi.common.core.text.Convert;

/**
 * 食堂档口主Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class CanteenStallServiceImpl implements ICanteenStallService 
{
    @Autowired
    private CanteenStallMapper canteenStallMapper;

    /**
     * 查询食堂档口主
     * 
     * @param stallId 食堂档口主主键
     * @return 食堂档口主
     */
    @Override
    public CanteenStall selectCanteenStallByStallId(Long stallId)
    {
        return canteenStallMapper.selectCanteenStallByStallId(stallId);
    }

    /**
     * 查询食堂档口主列表
     * 
     * @param canteenStall 食堂档口主
     * @return 食堂档口主
     */
    @Override
    public List<CanteenStall> selectCanteenStallList(CanteenStall canteenStall)
    {
        return canteenStallMapper.selectCanteenStallList(canteenStall);
    }

    /**
     * 新增食堂档口主
     * 
     * @param canteenStall 食堂档口主
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCanteenStall(CanteenStall canteenStall)
    {
        canteenStall.setCreateTime(DateUtils.getNowDate());
        int rows = canteenStallMapper.insertCanteenStall(canteenStall);
        insertCanteenDish(canteenStall);
        return rows;
    }

    /**
     * 修改食堂档口主
     * 
     * @param canteenStall 食堂档口主
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCanteenStall(CanteenStall canteenStall)
    {
        canteenStall.setUpdateTime(DateUtils.getNowDate());
        canteenStallMapper.deleteCanteenDishByStallId(canteenStall.getStallId());
        insertCanteenDish(canteenStall);
        return canteenStallMapper.updateCanteenStall(canteenStall);
    }

    /**
     * 批量删除食堂档口主
     * 
     * @param stallIds 需要删除的食堂档口主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCanteenStallByStallIds(String stallIds)
    {
        canteenStallMapper.deleteCanteenDishByStallIds(Convert.toStrArray(stallIds));
        return canteenStallMapper.deleteCanteenStallByStallIds(Convert.toStrArray(stallIds));
    }

    /**
     * 删除食堂档口主信息
     * 
     * @param stallId 食堂档口主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCanteenStallByStallId(Long stallId)
    {
        canteenStallMapper.deleteCanteenDishByStallId(stallId);
        return canteenStallMapper.deleteCanteenStallByStallId(stallId);
    }

    /**
     * 新增菜品台账子信息
     * 
     * @param canteenStall 食堂档口主对象
     */
    public void insertCanteenDish(CanteenStall canteenStall)
    {
        List<CanteenDish> canteenDishList = canteenStall.getCanteenDishList();
        Long stallId = canteenStall.getStallId();
        if (StringUtils.isNotNull(canteenDishList))
        {
            List<CanteenDish> list = new ArrayList<CanteenDish>();
            for (CanteenDish canteenDish : canteenDishList)
            {
                canteenDish.setStallId(stallId);
                list.add(canteenDish);
            }
            if (list.size() > 0)
            {
                canteenStallMapper.batchCanteenDish(list);
            }
        }
    }
}
