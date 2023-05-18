public class VM extends ComputerCluster {
  int VmId;
  int VMCPU;
  int VMRAM;
  String VMSoftware;

  public VM(int VmId, int VMCPU, int VMRAM, String VMSoftware) {
    this.VmId = VmId;
    this.VMCPU = VMCPU;
    this.VMRAM = VMRAM;
    this.VMSoftware = VMSoftware;

  }

}
