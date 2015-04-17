package com.example.tahmina.sunshine.app.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tahmina on 15-04-10.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForcast {


    private City city;

    private float message;




    @JsonProperty("list")
    private List<Weather> weathers;

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }





    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }






    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "WeatherForcast{" +
                "city=" + city +
                ", message=" + message +
                ", weathers=" + weathers +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class City{

        private int id;
        private String name;
        private String country;
        private int population;

        private Coord coord;

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        private Sys sys;


        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }



        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    ", mess="+""+
                    '}';
        }
        public class Sys{

            public int getPopulation() {
                return population;
            }

            public void setPopulation(int population) {
                this.population = population;
            }

            int population;


        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Coord{
            public double getLon() {
                return lon;
            }

            public void setLon(float lon) {
                this.lon = lon;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(float lat) {
                this.lat = lat;
            }

            private double lon;
            private double lat;

        }
    }


}


