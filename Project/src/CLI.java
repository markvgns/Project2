import java.util.ArrayList;
import java.util.Random;

import java.util.concurrent.*;


public class CLI {

 public static ArrayList<VM> VMs = new ArrayList<>();
 public static ArrayList<Programs> ProgramList = new ArrayList<>();

  static int numofPrograms = 0;

  private static int REMAIN_CPU = ComputerCluster.Max_CPU;
  private static int REMAIN_RAM = ComputerCluster.Max_RAM;
  private static int REMAIN_SSD = ComputerCluster.Max_SSD;
  private static int REMAIN_GPU = ComputerCluster.Max_GPU;
  private static int REMAIN_Ethernet = ComputerCluster.Max_Ethernet;
 
  public static int z = 0;
 
 public static int getZ() {
    return z;
  }

  public static void setZ(int z) {
    CLI.z = z;
  }

  // VM
  public static void createVm(int VMCPU, int VMRAM, String VMSoftware) {
    int VmID = createRandomInt();
    VM tempVm = new VM(VmID, VMCPU, VMRAM, VMSoftware);
    VMs.add(tempVm);
  }

  // PlainVM
  public static void createPlainVm(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD) {
    int VmID = createRandomInt();
    PlainVM tempVm = new PlainVM(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD);
    VMs.add(tempVm);

  }

  // VmGPU
  public static void createVmGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VmGPU) {
    int VmID = createRandomInt();
    VmGPU tempVm = new VmGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, VmGPU);
    VMs.add(tempVm);

  }

  // VmNetworked
  public static void createVmNetworked(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth) {
    int VmID = createRandomInt();
    VMNetworked tempVm = new VMNetworked(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth);
    VMs.add(tempVm);

  }

  // VmNetworkedGPU
  public static void createVmNetworkedGPU(int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {
    int VmID = createRandomInt();
    VMNetworkedGPU tempVm = new VMNetworkedGPU(VmID, VMCPU, VMRAM, VMSoftware, PlainSSD, Bandwidth, VMGPU);
    VMs.add(tempVm);

  }

  // Programs
  public static void createProgram(int CPU, int RAM, int SSD, int GPU, int Bandwidth, int ExpectedTime) {
    int pID = -5;
    while (pID < 0) {
      pID = createRandomInt();
    }
    Programs tempProgram = new Programs(pID, CPU, RAM, SSD, GPU, Bandwidth, ExpectedTime);
    ProgramList.add(tempProgram);
    if (numofPrograms > 1) {
      selectionSort(ProgramList);
    }
    numofPrograms++;

  }

  public static int createRandomInt() {
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

  public static void updateremaining(int VMCPU, int VMRAM, int PlainSSD, int Bandwidth, int gpu) {
    REMAIN_CPU -= VMCPU;
    REMAIN_RAM -= VMRAM;
    REMAIN_SSD -= PlainSSD;
    REMAIN_Ethernet -= Bandwidth;
    REMAIN_GPU -= gpu;
  }

  public static void delete(int VmID) {
    int tempCPU = 0;
    int tempRAM = 0;
    int tempGPU = 0;
    int tempBANDWIDTH = 0;
    int tempSSD = 0;

    for (int i = 0; i < VMs.size(); i++) {
      if (VmID == VMs.get(i).getVmId()) {
        tempCPU -= VMs.get(i).getVMCPU();
        tempRAM -= VMs.get(i).getVMRAM();

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

  public static void updateVM(int updateID, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int Bandwidth, int VMGPU) {

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

  

  public static void selectionSort(ArrayList<Programs> array) {
    for (int i = 0; i < array.size() - 1; i++) {
      int minOrder = i;

      for (int j = i + 1; j < array.size(); j++) {
        if (array.get(minOrder).getPriorityOrder() > array.get(j).getPriorityOrder()) {
          minOrder = j;
        }

      }

      Programs tempProgram = array.get(i);
      array.set(i, array.get(minOrder));
      array.set(minOrder, tempProgram);

    }

  }

  // Queue

  public void startqueue(int numofPrograms, ArrayList<Programs> ProgramList) {
    Programs[] array = new Programs[numofPrograms];
    array = ProgramList.toArray(array);

    Queue<Programs> BoundedQueue = new Queue<>(numofPrograms);
    //enqueue
    for (int i = 0; i < numofPrograms; i++) {
      BoundedQueue.enQueue(array[i]);
    }
    whileloop:
    while (true) {
      int programsadded = 0;
      //checking if a program is finished
      for (int i = 0; i < VMs.size(); i++) {
        for (int j = 0; j < VMs.get(i).ExecutingProjects.size(); j++) {
          if (VMs.get(i).ExecutingProjects.get(j).getExecutionTime() >= VMs.get(i).ExecutingProjects.get(j)
              .getProgramExpectedTime()) {
            removeProgram(j, i);
            programsadded--;
            if (programsadded == 0) {
              break whileloop;
            }

          }

        }
      }
      
      int k = VMload(BoundedQueue.peek());
      
      if (k != -5) {
        addProgram(BoundedQueue.deQueue(), k);
        
        programsadded++;
      } else {
        Programs tempProgram = BoundedQueue.peek();
        tempProgram.setRejectedTimes(tempProgram.getRejectedTimes()+1);
        if (BoundedQueue.peek().getRejectedTimes() < 3) {
          BoundedQueue.totheback(tempProgram);
          //sleeping
          long timetosleep = 2L;
          TimeUnit time = TimeUnit.SECONDS;
          try{
            time.sleep(timetosleep);
          }
          catch(InterruptedException e){
              System.out.println(e.getMessage());
          }
        } else {
          //kai kane pop
          // steile to se arxeio
        }

      }

    }

  }

  public int VMload(Programs Program) {
    int CPUload = 0;
    int k = -5;
    int RAMload = 0;
    int SSDload = 0;
    int GPUload = 0;
    int Bandwidthload = 0;
    double tempload;
    double minLoad = 1;
    

    for (int i = 0; i <= VMs.size(); i++) {

      CPUload = (Program.getProgramCores() + VMs.get(i).getAllocated_CPU()) / VMs.get(i).getVMCPU();

      RAMload = (Program.getProgramRAM() + VMs.get(i).getAllocated_RAM()) / VMs.get(i).getVMCPU();

      if (VMs.get(i) instanceof PlainVM) {
        SSDload = (Program.getProgramSSD() + ((PlainVM) VMs.get(i)).getAllocated_SSD())
            / ((PlainVM) VMs.get(i)).getPlainSSD();

      }
      if (VMs.get(i) instanceof VmGPU) {
        GPUload = (Program.getProgramGPU() + ((VmGPU) VMs.get(i)).getAllocated_GPU())
            / ((VmGPU) VMs.get(i)).getVMGPU();

      }

      if (VMs.get(i) instanceof VMNetworked) {
        Bandwidthload = (Program.getProgramBandwidth() + ((VMNetworked) VMs.get(i)).getAllocated_Bandwidth())
            / ((VMNetworked) VMs.get(i)).getBandwidth();

      }

      if (VMs.get(i) instanceof VMNetworkedGPU) {
        GPUload = (Program.getProgramGPU() + ((VMNetworkedGPU) VMs.get(i)).getAllocated_NetGPU())
            / ((VMNetworkedGPU) VMs.get(i)).getNetGPU();

      }

      if (VMs.get(i) instanceof PlainVM) {

        if (VMs.get(i) instanceof VmGPU || VMs.get(i) instanceof VMNetworked) {
          if (VMs.get(i) instanceof VMNetworkedGPU) {
            tempload = (CPUload + RAMload + SSDload + GPUload + Bandwidthload) / 5;
          } else {
            tempload = (CPUload + RAMload + SSDload + GPUload + Bandwidthload) / 4;
          }

        } else {
          tempload = (CPUload + RAMload + SSDload + GPUload + Bandwidthload) / 3;
        }

      } else {
        tempload = (CPUload + RAMload + SSDload + GPUload + Bandwidthload) / 2;
      }
      if ((Program.getProgramSSD() != 0 && !(VMs.get(i) instanceof PlainVM))
          || (Program.getProgramBandwidth() != 0 && !(VMs.get(i) instanceof VMNetworked))
          || (Program.getProgramGPU() != 0 && !(VMs.get(i) instanceof VmGPU))
          || (Program.getProgramGPU() != 0 && !(VMs.get(i) instanceof VMNetworkedGPU))) {

        continue;

      }
      if (tempload < minLoad) {
        minLoad = tempload;
        k = i;
      }
    }

    return k;

  }

  public void addProgram(Programs program, int index) {
    program.getProgramStartTime();
    VMs.get(index).ExecutingProjects.add(program);
    VMs.get(index).setAllocated_CPU(VMs.get(index).getAllocated_CPU() + program.getProgramCores());
    VMs.get(index).setAllocated_RAM(VMs.get(index).getAllocated_RAM() + program.getProgramRAM());

    if (VMs.get(index) instanceof PlainVM) {
      ((PlainVM) VMs.get(index))
          .setAllocated_SSD(((PlainVM) VMs.get(index)).getAllocated_SSD() + program.getProgramSSD());
    }

    if (VMs.get(index) instanceof VmGPU) {
      ((VmGPU) VMs.get(index)).setAllocated_GPU(((VmGPU) VMs.get(index)).getAllocated_GPU() + program.getProgramGPU());

    }

    if (VMs.get(index) instanceof VMNetworked) {
      ((VMNetworked) VMs.get(index)).setAllocated_Bandwidth(
          ((VMNetworked) VMs.get(index)).getAllocated_Bandwidth() + program.getProgramBandwidth());
    }

    if (VMs.get(index) instanceof VMNetworkedGPU) {
      ((VMNetworkedGPU) VMs.get(index))
          .setAllocated_NetGPU(((VMNetworkedGPU) VMs.get(index)).getAllocated_NetGPU() + program.getProgramGPU());
    }

  }

  public void removeProgram(int indexofprogram, int index) {
    VMs.get(index).setAllocated_CPU(
        VMs.get(index).getAllocated_CPU() - VMs.get(index).ExecutingProjects.get(indexofprogram).getProgramCores());
    VMs.get(index).setAllocated_RAM(
        VMs.get(index).getAllocated_RAM() - VMs.get(index).ExecutingProjects.get(indexofprogram).getProgramRAM());

    if (VMs.get(index) instanceof PlainVM) {
      ((PlainVM) VMs.get(index))
          .setAllocated_SSD(((PlainVM) VMs.get(index)).getAllocated_SSD()
              - VMs.get(index).ExecutingProjects.get(indexofprogram).getProgramSSD());
    }

    if (VMs.get(index) instanceof VmGPU) {
      ((VmGPU) VMs.get(index)).setAllocated_GPU(((VmGPU) VMs.get(index)).getAllocated_GPU()
          - VMs.get(index).ExecutingProjects.get(indexofprogram).getProgramGPU());

    }

    if (VMs.get(index) instanceof VMNetworked) {
      ((VMNetworked) VMs.get(index)).setAllocated_Bandwidth(
          ((VMNetworked) VMs.get(index)).getAllocated_Bandwidth()
              - VMs.get(index).ExecutingProjects.get(indexofprogram).getProgramBandwidth());
    }

    if (VMs.get(index) instanceof VMNetworkedGPU) {
      ((VMNetworkedGPU) VMs.get(index))
          .setAllocated_NetGPU(((VMNetworkedGPU) VMs.get(index)).getAllocated_NetGPU()
              - VMs.get(index).ExecutingProjects.get(indexofprogram).getProgramGPU());
    }

    VMs.get(index).ExecutingProjects.remove(indexofprogram);

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
