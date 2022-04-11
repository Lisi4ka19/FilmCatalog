package filmcatalog.filmcatalog.controllers;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


import java.util.List;

public class PagesInfo {

    private Page page;
    private List<PageItems> pageItemsList;


    public PagesInfo(Page page){
        this.page = page;
//        this.currentNumber = currentNumber;
        fillUpItems();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<PageItems> getPageItemsList() {
        return pageItemsList;
    }

    public void setPageItemsList(List<PageItems> pageItemsList) {
        this.pageItemsList = pageItemsList;
    }

    private void fillUpItems() {
        for (int i = 1; i < page.getTotalPages(); i++) {
            int currentNumber = page.getNumber();
            boolean isCurrentPage = currentNumber == i - 1;
            pageItemsList.add(new PageItems(i, isCurrentPage, ""));
        }
    }


    private class PageItems{

        private int number;
        private boolean isCurrent;
        private String URL;

        public PageItems(int number, boolean isCurrent, String URL) {
            this.number = number;
            this.isCurrent = isCurrent;
            this.URL = URL;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isCurrent() {
            return isCurrent;
        }

        public void setCurrent(boolean current) {
            isCurrent = current;
        }

        public String getURL() {
            return URL;
        }

        public void setURL(String URL) {
            this.URL = URL;
        }





    }

}
