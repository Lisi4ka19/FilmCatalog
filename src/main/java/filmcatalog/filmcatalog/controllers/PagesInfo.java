package filmcatalog.filmcatalog.controllers;

import org.springframework.data.domain.Page;

import java.util.List;

public class PagesInfo {

    private Page page;
    private List<PageItems> pageItemsList;

    public PagesInfo(Page page){
        this.page = page;
        fillUpItems();
    }

    private void fillUpItems(){
        for(int i=1; i< page.getTotalPages();i++){
            pageItemsList.add(new PageItems());
        }
    }

    private class PageItems{



    }

}
