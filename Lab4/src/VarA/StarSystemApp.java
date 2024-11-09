package VarA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Класс для представления Звезды
class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Звезда{" + "название='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Star)) return false;
        Star star = (Star) o;
        return Objects.equals(name, star.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

// Класс для представления Планеты
class Planet {
    private String name;
    private List<Moon> moons;

    public Planet(String name) {
        this.name = name;
        this.moons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Moon> getMoons() {
        return moons;
    }

    public void addMoon(Moon moon) {
        moons.add(moon);
    }

    @Override
    public String toString() {
        return "Планета{" + "название='" + name + '\'' + ", луны=" + moons + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

// Класс для представления Луны
class Moon {
    private String name;

    public Moon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Луна{" + "название='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moon)) return false;
        Moon moon = (Moon) o;
        return Objects.equals(name, moon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

// Класс для представления Звездной системы
class StarSystem {
    private Star star;
    private List<Planet> planets;

    public StarSystem(Star star) {
        this.star = star;
        this.planets = new ArrayList<>();
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public int getPlanetCount() {
        return planets.size();
    }

    public String getStarName() {
        return star.getName();
    }

    public void displaySystemInfo() {
        System.out.println("Задание выполнил: Муминов Рустам Б762-2");
        System.out.println("Звездная система:");
        System.out.println("Название звезды: " + getStarName());
        System.out.println("Количество планет: " + getPlanetCount());
        System.out.println("Планеты:");
        for (Planet planet : planets) {
            System.out.println(" - " + planet);
        }
    }

    @Override
    public String toString() {
        return "Звездная система{" + "звезда=" + star + ", планеты=" + planets + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StarSystem)) return false;
        StarSystem that = (StarSystem) o;
        return Objects.equals(star, that.star) && Objects.equals(planets, that.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(star, planets);
    }
}


public class StarSystemApp {
    public static void main(String[] args) {
        // Создаем звезду
        Star sun = new Star("Солнце");

        // Создаем звездную систему с этой звездой
        StarSystem solarSystem = new StarSystem(sun);

        // Создаем планеты
        Planet earth = new Planet("Земля");
        Planet mars = new Planet("Марс");

        // Создаем луны и добавляем к планетам
        earth.addMoon(new Moon("Луна"));
        mars.addMoon(new Moon("Фобос"));
        mars.addMoon(new Moon("Деймос"));

        // Добавляем планеты в звездную систему
        solarSystem.addPlanet(earth);
        solarSystem.addPlanet(mars);

        // Выводим информацию о звездной системе
        solarSystem.displaySystemInfo();
    }
}
