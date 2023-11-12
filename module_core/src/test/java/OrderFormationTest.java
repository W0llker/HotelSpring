import itAcadamy.repository.OrderDao;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrderFormationTest {
    @Mock
    private OrderDao orderDao;
    public void orderFormationHappyFlow() {
        OrderDao orderDao = Mockito.mock(OrderDao.class);
//        BDDMockito.given() вызов метода
//        BDDMockito.verify()
//        Assert.assertThrows()
//        BDDMockito.when()
    }
}
