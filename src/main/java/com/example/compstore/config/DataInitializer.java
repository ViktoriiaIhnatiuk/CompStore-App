package com.example.compstore.config;

import com.example.compstore.model.*;
import com.example.compstore.service.*;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Set;

@Component
public class DataInitializer {
    private static final Role USER_ROLE = Role.USER;
    private static final Role ADMIN_ROLE = Role.ADMIN;
    private final LaptopService laptopService;
    private final AllInOneService allInOneService;
    private final DesktopService desktopService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public DataInitializer(LaptopService laptopService,
                           AllInOneService allInOneService,
                           DesktopService desktopService,
                           UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.laptopService = laptopService;
        this.allInOneService = allInOneService;
        this.desktopService = desktopService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    public void inject() {
        Laptop lenovoThinkPad = new Laptop();
        lenovoThinkPad.setName("Lenovo ThinkPad P15");
        lenovoThinkPad.setComputerType(ComputerType.LAPTOP);
        lenovoThinkPad.setBrandName("Lenovo");
        lenovoThinkPad.setModel("ThinkPad P15 Gen 1");
        lenovoThinkPad.setCpuManufacturer("Intel");
        lenovoThinkPad.setProcessor("Core i9-10885H");
        lenovoThinkPad.setProcessorCount(8);
        lenovoThinkPad.setGraphicsProcessor("NVIDIA Quadro RTX 4000 Max-Q");
        lenovoThinkPad.setGraphicsProcessorMemory(8);
        lenovoThinkPad.setRamSize(32);
        lenovoThinkPad.setHardDriveType(HardDriveType.SSD);
        lenovoThinkPad.setHardDriveSize(1);
        lenovoThinkPad.setOperatingSystem("Windows 10 Pro");
        lenovoThinkPad.setDescription("Mobile Workstation");
        lenovoThinkPad.setDisplayDiagonalSize(15);
        lenovoThinkPad.setDisplayResolution("3840 x 2160");
        lenovoThinkPad.setRefreshRate(165);
        lenovoThinkPad.setHasWebCam(true);
        lenovoThinkPad.setBatteryLifeTimeInHours(10);
        lenovoThinkPad.setPrice(BigDecimal.valueOf(759.00));
        laptopService.create(lenovoThinkPad);

        AllInOne hpPavilion32 = new AllInOne();
        hpPavilion32.setName("HP Pavilion 32");
        hpPavilion32.setComputerType(ComputerType.ALL_IN_ONE);
        hpPavilion32.setBrandName("Hewlett Packard");
        hpPavilion32.setModel("Pavilion 32");
        hpPavilion32.setCpuManufacturer("Intel");
        hpPavilion32.setProcessor("Core i7-12700T");
        hpPavilion32.setProcessorCount(12);
        hpPavilion32.setGraphicsProcessor(" Intel UHD Graphics 770 ");
        hpPavilion32.setRamSize(16);
        hpPavilion32.setHardDriveType(HardDriveType.SSD);
        hpPavilion32.setHardDriveSize(1);
        hpPavilion32.setOperatingSystem("Windows 11 Home");
        hpPavilion32.setDescription("Wireless Mouse and Keyboard, Slim Design");
        hpPavilion32.setDisplayDiagonalSize(32);
        hpPavilion32.setDisplayResolution("3840 x 2160");
        hpPavilion32.setRefreshRate(144);
        hpPavilion32.setHasWebCam(true);
        hpPavilion32.setPrice(BigDecimal.valueOf(1399.88));
        allInOneService.create(hpPavilion32);

        Desktop skyTechChronos = new Desktop();
        skyTechChronos.setName("Skytech Chronos Mini");
        skyTechChronos.setComputerType(ComputerType.DESKTOP);
        skyTechChronos.setBrandName("Skytech Gaming");
        skyTechChronos.setModel("Chronos Mini");
        skyTechChronos.setCpuManufacturer("Intel");
        skyTechChronos.setProcessor("Core i3 10100F");
        skyTechChronos.setProcessorCount(4);
        skyTechChronos.setGraphicsProcessor("NVIDIA Geforce GTX 1650");
        skyTechChronos.setGraphicsProcessorMemory(4);
        skyTechChronos.setRamSize(8);
        skyTechChronos.setHardDriveType(HardDriveType.SSD);
        skyTechChronos.setHardDriveSize(500);
        skyTechChronos.setOperatingSystem("Windows 10 Home");
        skyTechChronos.setCaseLightingColor(CaseLightingColor.RGB);
        skyTechChronos.setDescription("Mini Gaming Computer PC Desktop");
        skyTechChronos.setPrice(BigDecimal.valueOf(639.00));
        desktopService.create(skyTechChronos);

        User admin = new User();
        admin.setEmail("admin@i.ua");
        admin.setPassword("admin1234");
        admin.setName("Mary Sue");
        admin.setRoles(Set.of(ADMIN_ROLE));
        userService.createUser(admin);
        User johnDoe = new User();
        johnDoe.setEmail("userjohn@i.ua");
        johnDoe.setName("John Doe");
        johnDoe.setPassword("user1234");
        johnDoe.setRoles(Set.of(USER_ROLE));
        shoppingCartService.createShoppingCart(johnDoe);
        userService.createUser(johnDoe);
        User janeDoe = new User();
        janeDoe.setEmail("userjane@i.ua");
        janeDoe.setName("Jane Doe");
        janeDoe.setPassword("user1234");
        janeDoe.setRoles(Set.of(USER_ROLE));
        shoppingCartService.createShoppingCart(janeDoe);
        userService.createUser(janeDoe);
    }
}
