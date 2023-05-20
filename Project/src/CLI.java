import java.util.ArrayList;
import java.util.Random;

public class CLI {

  ArrayList<VM> VMs = new ArrayList<>();
  ArrayList<Projects> ProjectList = new ArrayList<>();

  private static int REMAIN_CPU = ComputerCluster.Max_CPU;
  private static int REMAIN_RAM = ComputerCluster.Max_RAM;
  private static int REMAIN_SSD = ComputerCluster.Max_SSD;
  private static int REMAIN_GPU = ComputerCluster.Max_GPU;
  private static int REMAIN_Ethernet = ComputerCluster.Max_Ethernet;

  // VM
  public void createVm(int VMCPU, int VMRAM, String VMSoftware) {
    int VmID = createRandomInt();
    VM tempVm = new VM(VmID, VMCPU, VMRAM, VMSoftware);
    VMs.add(tempVm);
  }

  // PlainVM
  public void createPlainVm(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    int VmID = createRandomInt();
    PlainVM tempVm = new PlainVM(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD);
    VMs.add(tempVm);

  }

  // VmGPU
  public void createVmGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VmGPU) {
    int VmID = createRandomInt();
    VmGPU tempVm = new VmGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, VmGPU);
    VMs.add(tempVm);

  }

  // VmNetworked
  public void createVmNetworked(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    int VmID = createRandomInt();
    VMNetworked tempVm = new VMNetworked(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);
    VMs.add(tempVm);

  }

  // VmNetworkedGPU
  public void createVmNetworkedGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {
    int VmID = createRandomInt();
    VMNetworkedGPU tempVm = new VMNetworkedGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth, VMGPU);
    VMs.add(tempVm);

  }

  public int createRandomInt() {
    Random random = new Random();
    int randomInt = 0;
    int k = 1;

    while (k == 1) {
      randomInt = random.nextInt(Integer.MAX_VALUE - 2147483000) + 1;
      k = -1;
      for (int i = 0; i < VMs.size(); i++) {
        if (randomInt == VMs.get(i).getVmId()) {
          k = 1;
          break;
        }

      }
      if (k == -1) {
        break;

      }

    }
    return randomInt;

  }

  public void updateremaining(int VMCPU, int VMRAM, int PlainSSD, int Bandwidth, int gpu) {
    REMAIN_CPU -= VMCPU;
    REMAIN_RAM -= VMRAM;
    REMAIN_SSD -= PlainSSD;
    REMAIN_Ethernet -= Bandwidth;
    REMAIN_GPU -= gpu;
  }

  public void delete(int VmID) {
    int tempCPU = 0;
    int tempRAM = 0;
    int tempGPU = 0;
    int tempBANDWIDTH = 0;
    int tempSSD = 0;

    for (int i = 0; i < VMs.size(); i++) {
      if (VmID == VMs.get(i).getVmId()) {
        tempCPU = VMs.get(i).getVMCPU();
        tempRAM = VMs.get(i).getVMRAM();

        if (VMs.get(i) instanceof PlainVM) {

          tempSSD -= ((PlainVM) VMs.get(i)).getPlainSSD();
        }
        if (VMs.get(i) instanceof VmGPU) {

          tempGPU -= ((VmGPU) VMs.get(i)).getVMGPU();
        }

        if (VMs.get(i) instanceof VMNetworked) {

          tempBANDWIDTH -= ((VMNetworked) VMs.get(i)).getBandwidth();
        }

        if (VMs.get(i) instanceof VMNetworkedGPU) {

          tempGPU -= ((VMNetworkedGPU) VMs.get(i)).getNetGPU();
        }
        VMs.remove(i);
      }
    }

    updateremaining(tempCPU, tempRAM, tempSSD, tempBANDWIDTH, tempGPU);
  }

  public void updateVM(int updateID, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {

    if (VMCPU > REMAIN_CPU || VMRAM > REMAIN_RAM || PlainSSD > REMAIN_SSD || Bandwidth > REMAIN_Ethernet
        || VMGPU > REMAIN_GPU) {
      System.out.println("There are not enough resources available at the computer cluster!! Please try again. ");
      return;
    }

    for (int i = 0; i < VMs.size(); i++) {
      if (updateID == VMs.get(i).getVmId()) {
        if (VMCPU != 0) {
          VMs.get(i).setVMCPU(VMCPU + VMs.get(i).getVMCPU());
        }
        if (VMRAM != 0) {
          VMs.get(i).setVMRAM(VMRAM + VMs.get(i).getVMRAM());
        }
        if (VMSoftware != null) {
          VMs.get(i).setVMSoftware(VMSoftware);
        }
        if (PlainSSD != 0 && VMs.get(i) instanceof PlainVM) {
          ((PlainVM) VMs.get(i)).setPlainSSD(PlainSSD + ((PlainVM) VMs.get(i)).getPlainSSD());
        }
        if (Bandwidth != 0 && VMs.get(i) instanceof VMNetworked || VMs.get(i) instanceof VMNetworkedGPU) {
          ((VMNetworked) VMs.get(i)).setBandwidth(Bandwidth + ((VMNetworked) VMs.get(i)).getBandwidth());
        }
        if (VMGPU != 0 && VMs.get(i) instanceof VMNetworkedGPU || VMs.get(i) instanceof VmGPU) {
          ((VMNetworkedGPU) VMs.get(i)).setNetGPU(VMGPU + ((VMNetworkedGPU) VMs.get(i)).getNetGPU());
        }

        updateremaining(VMCPU, VMRAM, PlainSSD, Bandwidth, VMGPU);

      }

    }
  }

  public void reportVMs(int reportID, int k) {
    if (k == 1) /* kane report ola */
    {
      for (int j = 0; j < VMs.size(); j++) {
        if (VMs.get(j) instanceof VM) {
          System.out.println(VMs.get(j).getVMCPU() + "\t" + VMs.get(j).getVMRAM() + "\t" + VMs.get(j).getVMSoftware());

        }
        if (VMs.get(j) instanceof PlainVM) {
          System.out.println("\t" + ((PlainVM) VMs.get(j)).getPlainSSD());
        }
        if (VMs.get(j) instanceof VmGPU) {
          System.out.println("\t" + ((VmGPU) VMs.get(j)).getVMGPU());
        }
        if (VMs.get(j) instanceof VMNetworked) {
          System.out.println("\t" + ((VMNetworked) VMs.get(j)).getBandwidth());
        }
        if (VMs.get(j) instanceof VMNetworkedGPU) {
          System.out.println("\t" + ((VMNetworkedGPU) VMs.get(j)).getNetGPU());
        }

      }

    } else if (k == 0) /* ena mono */
    {
      for (int i = 0; i < VMs.size(); i++) {
        if (reportID == VMs.get(i).getVmId()) {
          if (VMs.get(i) instanceof VM) {
            System.out
                .println(VMs.get(i).getVMCPU() + "\t" + VMs.get(i).getVMRAM() + "\t" + VMs.get(i).getVMSoftware());

          }
          if (VMs.get(i) instanceof PlainVM) {
            System.out.println("\t" + ((PlainVM) VMs.get(i)).getPlainSSD());
          }
          if (VMs.get(i) instanceof VmGPU) {
            System.out.println("\t" + ((VmGPU) VMs.get(i)).getVMGPU());
          }
          if (VMs.get(i) instanceof VMNetworked) {
            System.out.println("\t" + ((VMNetworked) VMs.get(i)).getBandwidth());
          }
          if (VMs.get(i) instanceof VMNetworkedGPU) {
            System.out.println("\t" + ((VMNetworkedGPU) VMs.get(i)).getNetGPU());
          }

        }

      }

    }

  }

  public static int getREMAIN_CPU() {
    return REMAIN_CPU;
  }

  public static int getREMAIN_RAM() {
    return REMAIN_RAM;
  }

  public static int getREMAIN_SSD() {
    return REMAIN_SSD;
  }

  public static int getREMAIN_GPU() {
    return REMAIN_GPU;
  }

  public static int getREMAIN_Ethernet() {
    return REMAIN_Ethernet;
  }

}
