package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OfficeDocumentMapper;
import com.ruoyi.system.domain.OfficeDocument;
import com.ruoyi.system.service.IOfficeDocumentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公文流转Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class OfficeDocumentServiceImpl implements IOfficeDocumentService 
{
    @Autowired
    private OfficeDocumentMapper officeDocumentMapper;

    /**
     * 查询公文流转
     * 
     * @param docId 公文流转主键
     * @return 公文流转
     */
    @Override
    public OfficeDocument selectOfficeDocumentByDocId(Long docId)
    {
        return officeDocumentMapper.selectOfficeDocumentByDocId(docId);
    }

    /**
     * 查询公文流转列表
     * 
     * @param officeDocument 公文流转
     * @return 公文流转
     */
    @Override
    public List<OfficeDocument> selectOfficeDocumentList(OfficeDocument officeDocument)
    {
        return officeDocumentMapper.selectOfficeDocumentList(officeDocument);
    }

    /**
     * 新增公文流转
     * 
     * @param officeDocument 公文流转
     * @return 结果
     */
    @Override
    public int insertOfficeDocument(OfficeDocument officeDocument)
    {
        officeDocument.setCreateTime(DateUtils.getNowDate());
        return officeDocumentMapper.insertOfficeDocument(officeDocument);
    }

    /**
     * 修改公文流转
     * 
     * @param officeDocument 公文流转
     * @return 结果
     */
    @Override
    public int updateOfficeDocument(OfficeDocument officeDocument)
    {
        officeDocument.setUpdateTime(DateUtils.getNowDate());
        return officeDocumentMapper.updateOfficeDocument(officeDocument);
    }

    /**
     * 批量删除公文流转
     * 
     * @param docIds 需要删除的公文流转主键
     * @return 结果
     */
    @Override
    public int deleteOfficeDocumentByDocIds(String docIds)
    {
        return officeDocumentMapper.deleteOfficeDocumentByDocIds(Convert.toStrArray(docIds));
    }

    /**
     * 删除公文流转信息
     * 
     * @param docId 公文流转主键
     * @return 结果
     */
    @Override
    public int deleteOfficeDocumentByDocId(Long docId)
    {
        return officeDocumentMapper.deleteOfficeDocumentByDocId(docId);
    }
}
