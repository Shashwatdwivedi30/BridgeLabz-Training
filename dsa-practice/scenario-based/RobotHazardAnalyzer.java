import java.util.*;

class RobotSafetyException extends Exception{
    public RobotSafetyException(String message){
      super(message);
    }
}
public class RobotHazardAnalyzer {
      public static double CalculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException{

        if(armPrecision < 0.0 || armPrecision > 1.0){
          throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        if(workerDensity < 1 || workerDensity > 20){
          throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        if(!machineryState.equals("Worn") && !machineryState.equals("Faulty") && !machineryState.equals("Critical")){
          throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        double machineRiskFactor = 0.0;
        if(machineryState.equals("Worn")){
          machineRiskFactor = 1.3;
        }
        else if(machineryState.equals("Faulty")){
          machineRiskFactor = 2.0;
        }
        else if(machineryState.equals("Critical")){
          machineRiskFactor = 3.0;
        }

        double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
        return hazardRisk;
      }

      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();
        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();
        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.next();

        double result = 0.0;
        try {
          result = CalculateHazardRisk(armPrecision, workerDensity, machineryState);
          System.out.println("Robot Hazard Risk Score: "+result);
        } catch (RobotSafetyException e) {
          System.out.println(e.getMessage());
        }
      }
}