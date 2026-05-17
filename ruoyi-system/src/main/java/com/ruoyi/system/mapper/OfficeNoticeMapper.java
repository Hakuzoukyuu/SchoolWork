package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OfficeNotice;

/**
 * 行政办公通知Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface OfficeNoticeMapper 
{
    /**
     * 查询行政办公通知
     * 
     * @param noticeId 行政办公通知主键
     * @return 行政办公通知
     */
    public OfficeNotice selectOfficeNoticeByNoticeId(Long noticeId);

    /**
     * 查询行政办公通知列表
     * 
     * @param officeNotice 行政办公通知
     * @return 行政办公通知集合
     */
    public List<OfficeNotice> selectOfficeNoticeList(OfficeNotice officeNotice);

    /**
     * 新增行政办公通知
     * 
     * @param officeNotice 行政办公通知
     * @return 结果
     */
    public int insertOfficeNotice(OfficeNotice officeNotice);

    /**
     * 修改行政办公通知
     * 
     * @param officeNotice 行政办公通知
     * @return 结果
     */
    public int updateOfficeNotice(OfficeNotice officeNotice);

    /**
     * 删除行政办公通知
     * 
     * @param noticeId 行政办公通知主键
     * @return 结果
     */
    public int deleteOfficeNoticeByNoticeId(Long noticeId);

    /**
     * 批量删除行政办公通知
     * 
     * @param noticeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOfficeNoticeByNoticeIds(String[] noticeIds);
}
