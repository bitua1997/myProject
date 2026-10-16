package parkinglot;

public class Vehicle{
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle (String vehicleNumber,VehicleType vehicleType)
    {
        this.vehicleNumber=vehicleNumber;
        this.vehicleType=vehicleType;
    }

    public String getvehicleNumber()
    {
        return vehicleNumber;
    }

    public VehicleType getvehicleType()
    {
        return vehicleType;
    }
}