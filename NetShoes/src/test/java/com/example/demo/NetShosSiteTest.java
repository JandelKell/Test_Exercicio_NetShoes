package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class NetShosSiteTest {
	private void access_Site() {
		System.setProperty("webdriver.chrome.driver", "D:\\beckaup\\Documents\\spring aula\\chromedriver.exe");
		NetShoesSite page = new NetShoesSite();
		String title = page.getTitle();
		System.out.println(title);
		assertTrue(title.toLowerCase().endsWith("netshoes"));
		page.closed();
	}

	private void search_Item(final String item) {
		System.setProperty("webdriver.chrome.driver", "D:\\beckaup\\Documents\\spring aula\\chromedriver.exe");
		NetShoesSite page = new NetShoesSite();
		WebElement inputSearch = page.getElementByid("search-input");
		inputSearch.sendKeys(item);
		inputSearch.submit();
		String title = page.getTitle();
		assertTrue(title.toLowerCase().startsWith(item));

	}

	private void access_Item(final String item) {
		System.setProperty("webdriver.chrome.driver", "D:\\beckaup\\Documents\\spring aula\\chromedriver.exe");
		NetShoesSite page = new NetShoesSite();
		WebElement inputSearch = page.getElementByid("search-input");
		inputSearch.sendKeys(item);
		inputSearch.submit();
		WebElement primeiro_produto = page.getElementByxPath("/html/body/main/section/section[2]/div[4]/div[1]/a[1]/div/div[1]/div[2]/img");
		String nome_primeiro_produto = page.getElementByxPath("/html/body/main/section/section[2]/div[4]/div[1]/a[1]/div/div[2]/div[1]/span").getText();
		primeiro_produto.click();
		String name_produto = page.getTitle();
		System.out.println(nome_primeiro_produto);
		assertTrue(name_produto.startsWith(nome_primeiro_produto));
		page.closed();
	}

	@Test
	public void testAccesSite() {
		access_Site();
	}

	@Test
	public void testSearchItem() {
		search_Item("nike");
	}

	@Test
	public void testAccessItem() {
		access_Item("nike");
	}
}
