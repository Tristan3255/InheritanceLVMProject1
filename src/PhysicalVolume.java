import java.util.UUID;
public class PhysicalVolume extends LVMSYSTEM{

    private PhysicalDrive physicalDrive;
    public PhysicalVolume(String name, PhysicalDrive physicalDrive){
        super(name, UUID.randomUUID());
        this.physicalDrive = physicalDrive;
    }

    public PhysicalDrive getHardDrive(){
        return physicalDrive;
    }




}
