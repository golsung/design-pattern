class Car {
    private String model;
    private String brand;
    private String color;
    private int maxSpeed;
  
    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.brand = builder.brand;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

   
    public static CarBuilder builder(String model, String brand) {
        return new CarBuilder(model, brand);
    }

   
    public static class CarBuilder {
        // 필수 인자
        private String model;
        private String brand;
        private String color; 
        private int maxSpeed; 
       
        public CarBuilder(String model, String brand) {
            this.model = model;
            this.brand = brand;
        }
        
        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }
        
        public CarBuilder maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }
        
        public Car build() {
            return new Car(this);
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder("Corolla", "Toyota").build();
        Car car2 = Car.builder("Model S", "Tesla").color("Red").maxSpeed(250).build();
        Car car3 = Car.builder("Corolla", "Toyota").build();
    }
}