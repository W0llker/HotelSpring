package service.order;

import itAcadamy.mapper.AmenitiesMapper;
import itAcadamy.mapper.OrderMapper;
import itAcadamy.repository.AmenitiesDao;
import itAcadamy.repository.ClientDao;
import itAcadamy.repository.OrderDao;
import itAcadamy.repository.RoomDao;
import itAcadamy.service.EmailService;
import org.mockito.Mock;

public class OrderServiceTest {
    @Mock
    protected OrderDao orderDao;
    @Mock
    protected RoomDao roomDao;
    @Mock
    protected  ClientDao clientDao;
    @Mock
    protected  AmenitiesDao amenitiesDao;
    @Mock
    protected  OrderMapper orderMapper;
    @Mock
    protected  AmenitiesMapper amenitiesMapper;
    @Mock
    protected  EmailService emailService;
}
