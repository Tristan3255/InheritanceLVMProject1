import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<PhysicalDrive> PHD = new ArrayList<PhysicalDrive>();

        System.out.println("Welcome to the LMV Creator");
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        while(!(userChoice.equals("exit"))) {
            System.out.println("Enter one of the following commands\n-install-drive/list-drives\n-pvcreate/pvlist\n-vgcreate/vgextend/vglist\n-lvcreate/lvlist\n-exit");
            userChoice = input.nextLine();
            if(userChoice.equals("install-drive")){
                boolean error = false;
                System.out.print("install-drive ");
                String pDrive = input.nextLine();
                String name = pDrive.substring(0, pDrive.indexOf(" "));
                int size = Integer.parseInt(pDrive.substring(pDrive.indexOf(" ") + 1, pDrive.length()-1));
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
            if(userChoice.equals("list-drives")){
                System.out.println();
                for(int x = 0; x < PHD.size(); x++){
                    System.out.print(PHD.get(x).getName() + " [" + PHD.get(x).getSize() + "G]");
                    System.out.println();
                }
                System.out.println();
            }

        }

    }
}
