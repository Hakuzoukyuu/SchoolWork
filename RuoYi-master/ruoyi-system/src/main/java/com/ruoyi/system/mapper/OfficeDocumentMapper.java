package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OfficeDocument;

/**
 * 公文流转Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface OfficeDocumentMapper 
{
    /**
     * 查询公文流转
     * 
     * @param docId 公文流转主键
     * @return 公文流转
     */
    public OfficeDocument selectOfficeDocumentByDocId(Long docId);

    /**
     * 查询公文流转列表
     * 
     * @param officeDocument 公文流转
     * @return 公文流转集合
     */
    public List<OfficeDocument> selectOfficeDocumentList(OfficeDocument officeDocument);

    /**
     * 新增公文流转
     * 
     * @param officeDocument 公文流转
     * @return 结果
     */
    public int insertOfficeDocument(OfficeDocument officeDocument);

    /**
     * 修改公文流转
     * 
     * @param officeDocument 公文流转
     * @return 结果
     */
    public int updateOfficeDocument(OfficeDocument officeDocument);

    /**
     * 删除公文流转
     * 
     * @param docId 公文流转主键
     * @return 结果
     */
    public int deleteOfficeDocumentByDocId(Long docId);

    /**
     * 批量删除公文流转
     * 
     * @param docIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOfficeDocumentByDocIds(String[] docIds);
}
