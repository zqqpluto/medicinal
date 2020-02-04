package cn.pluto.medicinal.untils;

import cn.pluto.medicinal.pojo.KnowledgeService;

import java.util.List;

/**
 * @author zqq
 * @create 2020-02-03-11:16
 */
public class PageKnowledge {
    private Integer currentPage;
    private Integer totalPages;
    private List<KnowledgeService> knowledgeService;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<KnowledgeService> getKnowledgeService() {
        return knowledgeService;
    }

    public void setKnowledgeService(List<KnowledgeService> knowledgeService) {
        this.knowledgeService = knowledgeService;
    }
}
