package com.epam.page_object.pages;


import com.epam.page_object.base.Driver;

public class AbstractPage {

    public void getURL(String url) {
        Driver.Instance.get(url);
    }
}
