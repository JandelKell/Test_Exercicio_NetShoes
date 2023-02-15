package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NetShoesSite extends Page {

    public NetShoesSite() {
        super();
        driver.get("https://www.netshoes.com.br/");
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getElementByid(String entrada) {
        return driver.findElement((By.id(entrada)));
    }

    public WebElement getElementByxPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    @Override
    public void closed() {
        driver.close();
    }
}
