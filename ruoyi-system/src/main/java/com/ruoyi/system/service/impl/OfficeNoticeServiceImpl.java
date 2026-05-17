package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OfficeNoticeMapper;
import com.ruoyi.system.domain.OfficeNotice;
import com.ruoyi.system.service.IOfficeNoticeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 行政办公通知Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class OfficeNoticeServiceImpl implements IOfficeNoticeService 
{
    @Autowired
    private OfficeNoticeMapper officeNoticeMapper;

    /**
     * 查询行政办公通知
     * 
     * @param noticeId 行政办公通知主键
     * @return 行政办公通知
     */
    @Override
    public OfficeNotice selectOfficeNoticeByNoticeId(Long noticeId)
    {
        return officeNoticeMapper.selectOfficeNoticeByNoticeId(noticeId);
    }

    /**
     * 查询行政办公通知列表
     * 
     * @param officeNotice 行政办公通知
     * @return 行政办公通知
     */
    @Override
    public List<OfficeNotice> selectOfficeNoticeList(OfficeNotice officeNotice)
    {
        return officeNoticeMapper.selectOfficeNoticeList(officeNotice);
    }

    /**
     * 新增行政办公通知
     * 
     * @param officeNotice 行政办公通知
     * @return 结果
     */
    @Override
    public int insertOfficeNotice(OfficeNotice officeNotice)
    {
        officeNotice.setCreateTime(DateUtils.getNowDate());
        return officeNoticeMapper.insertOfficeNotice(officeNotice);
    }

    /**
     * 修改行政办公通知
     * 
     * @param officeNotice 行政办公通知
     * @return 结果
     */
    @Override
    public int updateOfficeNotice(OfficeNotice officeNotice)
    {
        officeNotice.setUpdateTime(DateUtils.getNowDate());
        return officeNoticeMapper.updateOfficeNotice(officeNotice);
    }

    /**
     * 批量删除行政办公通知
     * 
     * @param noticeIds 需要删除的行政办公通知主键
     * @return 结果
     */
    @Override
    public int deleteOfficeNoticeByNoticeIds(String noticeIds)
    {
        return officeNoticeMapper.deleteOfficeNoticeByNoticeIds(Convert.toStrArray(noticeIds));
    }

    /**
     * 删除行政办公通知信息
     * 
     * @param noticeId 行政办公通知主键
     * @return 结果
     */
    @Override
    public int deleteOfficeNoticeByNoticeId(Long noticeId)
    {
        return officeNoticeMapper.deleteOfficeNoticeByNoticeId(noticeId);
    }
}
