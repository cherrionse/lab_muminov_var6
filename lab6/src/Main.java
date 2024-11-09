public class Main {
    public static void main(String[] args) {
        // Создаем грузовой вагон
        FreightWagon freightWagon = new FreightWagon("FW123", 20.5, true, true);
        freightWagon.setDestination("Москва");
        freightWagon.setOwner("Транспортная компания");
        System.out.println("Задание выполнил: Муминов Рустам Б762-2");
        System.out.println("Грузовой вагон:");
        System.out.println("Регистрационный номер: " + freightWagon.getRegistrationNumber());
        System.out.println("Пункт назначения: " + freightWagon.getDestination());
        System.out.println("Владелец: " + freightWagon.getOwner());
        System.out.println("Статус: " + freightWagon.getStatus());
        System.out.println("Хрупкость груза: " + freightWagon.isFragile());
        System.out.println("Ценность груза: " + freightWagon.isValuable());

        freightWagon.load();
        System.out.println("Статус после загрузки: " + freightWagon.getStatus());

        freightWagon.sendToDestination();
        System.out.println("Статус после отправки: " + freightWagon.getStatus());

        freightWagon.unload();
        System.out.println("Статус после выгрузки: " + freightWagon.getStatus());

        freightWagon.repair();
        System.out.println("Статус после ремонта: " + freightWagon.getStatus());

        freightWagon.service();
        System.out.println("Статус после обслуживания: " + freightWagon.getStatus());

        System.out.println("---------------");

        // Создаем пассажирский вагон
        PassengerWagon passengerWagon = new PassengerWagon("PW456", 15.0, 100);
        passengerWagon.setDestination("Санкт-Петербург");
        passengerWagon.setOwner("Железнодорожная компания");

        System.out.println("Пассажирский вагон:");
        System.out.println("Регистрационный номер: " + passengerWagon.getRegistrationNumber());
        System.out.println("Пункт назначения: " + passengerWagon.getDestination());
        System.out.println("Владелец: " + passengerWagon.getOwner());
        System.out.println("Вместимость пассажиров: " + passengerWagon.getPassengerCapacity());
        System.out.println("Статус: " + passengerWagon.getStatus());

        passengerWagon.sendToDestination();
        System.out.println("Статус после отправки: " + passengerWagon.getStatus());

        passengerWagon.repair();
        System.out.println("Статус после ремонта: " + passengerWagon.getStatus());

        passengerWagon.service();
        System.out.println("Статус после обслуживания: " + passengerWagon.getStatus());
    }
}
