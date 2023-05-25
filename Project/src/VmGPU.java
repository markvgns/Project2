public class VmGPU extends PlainVM {
  private int VMGPU;

  private int Allocated_GPU;

  public VmGPU(int VmId, int VMCPU, int VMRAM, String VMSoftware, int PlainSSD, int VMGPU) {
    super(VmId, VMCPU, VMRAM, VMSoftware, PlainSSD);

    this.VMGPU = VMGPU;

  }

  public int getVMGPU() {
    return VMGPU;
  }

  public void setVMGPU(int vMGPU) {
    VMGPU = vMGPU;
  }

  public int getAllocated_GPU() {
    return Allocated_GPU;
  }

  public void setAllocated_GPU(int allocated_GPU) {
    Allocated_GPU = allocated_GPU;
  }
}
