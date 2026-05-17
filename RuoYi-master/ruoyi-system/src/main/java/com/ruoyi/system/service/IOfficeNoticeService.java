package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OfficeNotice;

/**
 * 行政办公通知Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IOfficeNoticeService 
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
     * 批量删除行政办公通知
     * 
     * @param noticeIds 需要删除的行政办公通知主键集合
     * @return 结果
     */
    public int deleteOfficeNoticeByNoticeIds(String noticeIds);

    /**
     * 删除行政办公通知信息
     * 
     * @param noticeId 行政办公通知主键
     * @return 结果
     */
    public int deleteOfficeNoticeByNoticeId(Long noticeId);
}
