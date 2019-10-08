import in.rbaskets.controllers.basket.BasketCommand;
import in.rbaskets.models.AccessToken;
import in.rbaskets.models.BasketModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBasket {
    private String idBasket = RandomStringUtils.randomAlphabetic(5);
    private String token;
    private BasketModel basket = new BasketModel("https://", true, true, true, 300);

    @BeforeMethod
    public void create() {
        AccessToken token = new BasketCommand(idBasket).createBasket(basket);
        assertThat(token.getToken()).hasSize(44);
        this.token = token.getToken();
    }

    @Test (description = "Получаем корзину")
    public void getBasket() {
        BasketModel basketResponse = new BasketCommand(idBasket).getBasket(token);
        assertThat(basketResponse).isEqualToComparingFieldByFieldRecursively(basket);
    }

    @Test (description = "Обновляем данные корзины ")
    public void updateBasket() {
        String response = new BasketCommand(idBasket).updateBasket(token, basket);
        assertThat(response).isEmpty();

    }

    @AfterMethod
    public void deleteBasket() {
        String response = new BasketCommand(idBasket).deleteBasket(token);
        assertThat(response).isEmpty();
        String deletedBasket = new BasketCommand(idBasket).getDeletedBasket(token);
        assertThat(deletedBasket).isEmpty();

    }
}
