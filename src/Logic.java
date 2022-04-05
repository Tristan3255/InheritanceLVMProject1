import java.util.ArrayList;

public class Logic {

    public Logic(){

    }


    ArrayList<PhysicalDrive> PHD = new ArrayList<PhysicalDrive>();
    ArrayList<PhysicalVolume> PV = new ArrayList<PhysicalVolume>();
    ArrayList<LogicalVolume> LV = new ArrayList<LogicalVolume>();
    ArrayList<VolumeGroup> VG = new ArrayList<VolumeGroup>();

    public ArrayList<PhysicalDrive> getPHD() {
        return PHD;
    }

    public ArrayList<PhysicalVolume> getPV() {
        return PV;
    }

    public ArrayList<LogicalVolume> getLV() {
        return LV;
    }

    public ArrayList<VolumeGroup> getVG() {
        return VG;
    }

    public void Runner(String choice){
        if(choice.equals("list-drives")){
            listDrives();
        }
        else if(choice.contains("install-drive")){
            installDrives(choice);
        }
        else{
            System.out.println("That is not a valid command, please try again.");
        }

    }

    public void installDrives(String input){
        boolean error = false;
        String rest = input.substring(14);
        String name = rest.substring(0, rest.indexOf(" "));
        int size = Integer.parseInt(rest.substring(rest.indexOf(" ") + 1, rest.length()-1));
        PhysicalDrive drive = new PhysicalDrive(name,size);

        for(int i = 0; i < PHD.size(); i++){
            if(PHD.get(i).getName().equals(name)){
                error = true;
            }
        }

        if(error == false){
            PHD.add(drive);
            System.out.println();
            System.out.println("Installation Complete");
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("This drive has already been installed");
            System.out.println();
        }
    }

    public void listDrives(){
        if(PHD.size() == 0){
            System.out.println("You currently have no hard drives installed.");
        }
        else {
            for (int x = 0; x < PHD.size(); x++) {
                System.out.print(PHD.get(x).getName() + " [" + PHD.get(x).getSize() + "G]");
                System.out.println();
            }
        }
    }
}
