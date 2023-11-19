package service.order;

import itAcadamy.service.OrderService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaveOrderTest extends OrderServiceTest{
    @InjectMocks
    private OrderService orderService;

    public void positiveTest() {

    }
}
