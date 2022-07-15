package com.discom.springmvc.model;

public class PortfolioListModel {
    private Long portfolioMasterId;
    private String portfolioId;

    public PortfolioListModel() {
        super();

    }

    public PortfolioListModel(Long portfolioMasterId, String portfolioId) {
        super();
        this.portfolioMasterId = portfolioMasterId;
        this.portfolioId = portfolioId;
    }

    public Long getPortfolioMasterId() {
        return portfolioMasterId;
    }

    public void setPortfolioMasterId(Long portfolioMasterId) {
        this.portfolioMasterId = portfolioMasterId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }
}
