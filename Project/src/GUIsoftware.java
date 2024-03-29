import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GUIsoftware{
    


public static void main(String[] args)

{
 
    // File Frame
   
   

      FrameBuilder FileInfo = new FrameBuilder("File actions performed");

      
      
      PanelBuilder VMFileInfo = new PanelBuilder(0, 0, 300, 725);
      VMFileInfo.setBackground(Color.DARK_GRAY);
      FileInfo.add(VMFileInfo);
      
       ButtonBuilder VMFileButton = new ButtonBuilder("Next", 100, 525);
       VMFileInfo.add(VMFileButton);
       //----> kodikas gia epomeno frame
       VMFileButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e)
          {
             CLI.setZ(1);
             FileInfo.dispose();
             
          }
       });

      LableBuilder VMFilelabel = new LableBuilder("Create VMs from File:", 0, 0);
      VMFileInfo.add(VMFilelabel);

      ButtonBuilder VMsFileCreator = new ButtonBuilder("Get from File", 100, 100);
      VMsFileCreator.setBounds(100, 100, 125, 25);
      VMFileInfo.add(VMsFileCreator);

      VMsFileCreator.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            VMsFileCreator.setEnabled(false);
            //----> pare Vms apo file kai bale int p=1 oste apo kato na mhn bgalei error

            LableBuilder ErrorVMFile = new LableBuilder("No VMs found", 0, 150);
            VMFileInfo.add(ErrorVMFile);
            ErrorVMFile.repaint();
            ErrorVMFile.revalidate();

         }

      });
    
    
    
      PanelBuilder ProgramFileInfo = new PanelBuilder(310, 0, 330, 725);
      ProgramFileInfo.setBackground(Color.DARK_GRAY);
      FileInfo.add(ProgramFileInfo);

       ButtonBuilder ProgramFileButton = new ButtonBuilder("Next", 100, 525);
       ProgramFileInfo.add(ProgramFileButton);
      //----> kodikas gia epomeno frame
      ProgramFileButton.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e)
       {
          CLI.setZ(1);
          FileInfo.dispose();
       }
       });
      

      LableBuilder ProgramFilelabel = new LableBuilder("Create Programs from File:", 0, 0);
      ProgramFileInfo.add(ProgramFilelabel);

      ButtonBuilder ProgramFileCreator = new ButtonBuilder("Get from File", 100, 100);
      ProgramFileCreator.setBounds(100, 100, 125, 25);
      ProgramFileInfo.add(ProgramFileCreator);

      ProgramFileCreator.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            ProgramFileCreator.setEnabled(false);
            //----> pare Programss apo file kai bale int p=1 oste apo kato na mhn bgalei error

            LableBuilder ErrorProgramFile = new LableBuilder("No Programs found", 0, 150);
            ProgramFileInfo.add(ErrorProgramFile);

            ErrorProgramFile.repaint();
            ErrorProgramFile.revalidate();
         }

      });
    

     

      while (CLI.getZ() == 0) {
         try {
             Thread.sleep(100);
         }catch (InterruptedException ex) {
            System.out.println("\n");
        }
      }
       

   if(CLI.getZ() ==1)
   {
      

      FrameBuilder InitialFrame = new FrameBuilder("Virtual Machine software");

      PanelBuilder CreateVMPanel = new PanelBuilder(0, 0, 315, 325);
      PanelBuilder DeleteVMPanel = new PanelBuilder(0, 335, 195, 325);
      PanelBuilder UpdateVMPanel = new PanelBuilder(325, 0, 315, 325);
      PanelBuilder ReportVMPanel = new PanelBuilder(205, 335, 225, 325);
      PanelBuilder DoneVMPanel = new PanelBuilder(440, 335, 225, 325);
      PanelBuilder NoSpaceVMPanel = new PanelBuilder(0, 40, 560, 290);
      PanelBuilder NoSpaceUpdateVMPanel = new PanelBuilder(0, 40, 560, 290);
 
      ButtonBuilder CreateVMButton = new ButtonBuilder("Create VM", 110, 15);
      //----> kodikas gia create
      CreateVMButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            CreateVMButton.setEnabled(false);
            LableBuilder CreateVMlabel1 = new LableBuilder("Enter number of VMs for creation:", 0, 41);
            CreateVMPanel.add(CreateVMlabel1);

            TextFieldBuilder numOfVMstext = new TextFieldBuilder(150, 41);
            CreateVMPanel.add(numOfVMstext);

            LableBuilder CreateVMlabel2 = new LableBuilder("VMType in capital: TYPE, CPU, RAM, Software, SSD, Bandwidth, GPU", 0, 55);
            CreateVMPanel.add(CreateVMlabel2);

            CreateVMPanel.revalidate();
            CreateVMPanel.repaint();

            numOfVMstext.addActionListener(new ActionListener()
               {
                  @Override
                  public void actionPerformed(ActionEvent e)
                  {

                     numOfVMstext.setEnabled(false);

                     String numofVMsInput = numOfVMstext.getText();
                     Scanner VMscanner = new Scanner(numofVMsInput);
                     
                     int numofVMs = VMscanner.nextInt();
                     
                     VMscanner.close();
            
                     for(int i=0;i<numofVMs;i++)
                    {
                     int k =69;
                     k += 14*i;
                     String VM="VM";
                     String PLAIN = "PLAIN";
                     String GPU = "GPU";
                     String NETWROKED = "NETWORKED";
                     String NETGPU = "NETGPU";
                     

                     LableBuilder CreateVMlabel3 = new LableBuilder("Enter VM:", 0, k);
                     CreateVMPanel.add(CreateVMlabel3);

                     TextFieldBuilder CreateVMtext = new TextFieldBuilder(50, k);
                     CreateVMPanel.add(CreateVMtext);

                     CreateVMPanel.revalidate();
                     CreateVMPanel.repaint();
                     
                     CreateVMtext.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           CreateVMtext.setEnabled(false);
                           String VMinfo = CreateVMtext.getText();

                           CreateVMPanel.revalidate();
                           CreateVMPanel.repaint();

                           Scanner VMInfoScanner = new Scanner(VMinfo);
                           VMInfoScanner.useDelimiter(",\\s*");
      
                           String type = VMInfoScanner.next();
                           int cpu = Integer.parseInt(VMInfoScanner.next());
                           int ram = Integer.parseInt(VMInfoScanner.next());
                           String software = VMInfoScanner.next();
                           int ssd = Integer.parseInt(VMInfoScanner.next());
                           int bandwidth = Integer.parseInt(VMInfoScanner.next());
                           int gpu = Integer.parseInt(VMInfoScanner.next());
      
                           VMInfoScanner.close();

                           CLI.updateremaining(cpu, ram, ssd, bandwidth, gpu);

                           if(cpu > CLI.getREMAIN_CPU() || ram > CLI.getREMAIN_RAM() || ssd > CLI.getREMAIN_SSD()
                           || bandwidth > CLI.getREMAIN_Ethernet() || gpu > CLI.getREMAIN_GPU())
                           {
                                 LableBuilder ErrorVMlabel1 = new LableBuilder("Not enough remaining cores in the cluster for the last new VM", 0, 100);
                                 NoSpaceVMPanel.add(ErrorVMlabel1);
                                 CreateVMPanel.add(NoSpaceVMPanel); 
                                 
                                 LableBuilder ErrorVMFixLabel = new LableBuilder("Enter new VM(1 try):", 0, 120);
                                 NoSpaceVMPanel.add(ErrorVMFixLabel);

                                 TextFieldBuilder ErrorFixText = new TextFieldBuilder(105, 120);
                                 NoSpaceVMPanel.add(ErrorFixText);

                                 ErrorFixText.addActionListener(new ActionListener() {
                                    
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {

                                       ErrorFixText.setEnabled(false);
                                       String FixVMinfo = CreateVMtext.getText();
      
                                       CreateVMPanel.revalidate();
                                       CreateVMPanel.repaint();
      
                                       Scanner FixVMInfoScanner = new Scanner(FixVMinfo);
                                       FixVMInfoScanner.useDelimiter(",\\s*");
            
                                       String Fixtype = FixVMInfoScanner.next();
                                       int Fixcpu = Integer.parseInt(FixVMInfoScanner.next());
                                       int Fixram = Integer.parseInt(FixVMInfoScanner.next());
                                       String Fixsoftware = FixVMInfoScanner.next();
                                       int Fixssd = Integer.parseInt(FixVMInfoScanner.next());
                                       int Fixbandwidth = Integer.parseInt(FixVMInfoScanner.next());
                                       int Fixgpu = Integer.parseInt(FixVMInfoScanner.next());
            
                                       FixVMInfoScanner.close();
      
                                       CLI.updateremaining(Fixcpu, Fixram, Fixssd, Fixbandwidth, Fixgpu);
      
                                       if(VM.equals(Fixtype))
                                       {
                                          CLI.createVm(Fixcpu, Fixram, Fixsoftware);
                                       }
                                       if(PLAIN.equals(Fixtype))
                                       {
                                          CLI.createPlainVm(Fixcpu, Fixram, Fixsoftware, Fixssd);
                                       }
                                       if(GPU.equals(Fixtype))
                                       {
                                          CLI.createVmGPU(Fixcpu, Fixram, Fixsoftware, Fixssd, Fixgpu);
                                       }
                                       if(NETWROKED.equals(Fixtype))
                                       {
                                          CLI.createVmNetworked(Fixcpu, Fixram, Fixsoftware, Fixssd, Fixbandwidth);
                                       }
                                       if(NETGPU.equals(Fixtype))
                                       {
                                          CLI.createVmNetworkedGPU(Fixcpu, Fixram, Fixsoftware, Fixssd, Fixbandwidth, Fixgpu);
                                       }
                  
                                       CreateVMPanel.revalidate();
                                       CreateVMPanel.repaint();   
                                       
                                       CLI.updateremaining(Fixcpu, Fixram, Fixssd, Fixbandwidth, Fixgpu);

                                    }

                                 });
                                 


                                 ButtonBuilder NoSpaceVMButton = new ButtonBuilder("Ok", 80, 250); 
                                 NoSpaceVMPanel.add(NoSpaceVMButton);

                                 CreateVMPanel.revalidate();
                                 CreateVMPanel.repaint();

                                 NoSpaceVMButton.addActionListener(new ActionListener() {
                                    
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {

                                       CreateVMPanel.remove(NoSpaceVMPanel);

                                       CreateVMPanel.revalidate();
                                       CreateVMPanel.repaint();

                                    }

                                  

                                 });
                                 
                               
                           }

                           if(VM.equals(type))
                           {
                              CLI.createVm(cpu, ram, software);
                           }
                           if(PLAIN.equals(type))
                           {
                              CLI.createPlainVm(cpu, ram, software, ssd);
                           }
                           if(GPU.equals(type))
                           {
                              CLI.createVmGPU(cpu, ram, software, ssd, gpu);
                           }
                           if(NETWROKED.equals(type))
                           {
                              CLI.createVmNetworked(cpu, ram, software, ssd, bandwidth);
                           }
                           if(NETGPU.equals(type))
                           {
                              CLI.createVmNetworkedGPU(cpu, ram, software, ssd, bandwidth, gpu);
                           }
      
                           CreateVMPanel.revalidate();
                           CreateVMPanel.repaint();   
                           
                           CLI.updateremaining(cpu, ram, ssd, bandwidth, gpu);

                           
      
                        }
                     });


                    }
                    
                  }
                
               
               });

         }
      });
      ButtonBuilder UpdateVMButton = new ButtonBuilder("Update VM", 110, 15);
      //---> kodikas gia update
      UpdateVMButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            UpdateVMButton.setEnabled(false);
            LableBuilder UpdateVMlabel1 = new LableBuilder("Enter the ID of the VM for update:", 0, 41);
            UpdateVMPanel.add(UpdateVMlabel1);

            TextFieldBuilder UpdateVMIDtext = new TextFieldBuilder(150, 41);
            UpdateVMPanel.add(UpdateVMIDtext);

            UpdateVMPanel.revalidate();
            UpdateVMPanel.repaint(); 

            UpdateVMIDtext.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                     UpdateVMIDtext.setEnabled(false);
                     String updateIDinput = UpdateVMIDtext.getText();
                     Scanner Updatescanner = new Scanner(updateIDinput);
                     int IDforupdate = Updatescanner.nextInt();
                     Updatescanner.close();

                     UpdateVMPanel.revalidate();
                     UpdateVMPanel.repaint();
            
                     for(int i=0;i<CLI.VMs.size();i++)
                    {

                     if(IDforupdate == CLI.VMs.get(i).getVmId())
                     {

                     LableBuilder UpdateVMlabel2 = new LableBuilder("Enter updated cores:", 0, 55);
                     UpdateVMPanel.add(UpdateVMlabel2);

                     TextFieldBuilder UpdateVMtext = new TextFieldBuilder(100, 55);
                     UpdateVMPanel.add(UpdateVMtext);

                     UpdateVMtext.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           UpdateVMtext.setEnabled(false);
                           String UpdateInfo = UpdateVMtext.getText();
                           Scanner UpdateInfoScanner = new Scanner(UpdateInfo);
                           

                           int cpu = UpdateInfoScanner.nextInt();
                           int ram = UpdateInfoScanner.nextInt();
                           String software = UpdateInfoScanner.next();
                           int ssd = UpdateInfoScanner.nextInt();
                           int bandwidth = UpdateInfoScanner.nextInt();
                           int gpu = UpdateInfoScanner.nextInt();

                           UpdateInfoScanner.close();

                           CLI.updateremaining(cpu, ram, ssd, bandwidth, gpu);

                           if(cpu > CLI.getREMAIN_CPU() || ram > CLI.getREMAIN_RAM() || ssd > CLI.getREMAIN_SSD()
                           || bandwidth > CLI.getREMAIN_Ethernet() || gpu > CLI.getREMAIN_GPU())
                           {
                                LableBuilder ErrorUpdatelabel1 = new LableBuilder("Not enough remaining cores in the cluster for such update", 0, 100);
                                NoSpaceUpdateVMPanel.add(ErrorUpdatelabel1);
                                UpdateVMPanel.add(NoSpaceUpdateVMPanel); 

                                ButtonBuilder noSpaceUpdateVMButton = new ButtonBuilder("Ok", 80, 250); 
                                NoSpaceUpdateVMPanel.add(noSpaceUpdateVMButton);
                                noSpaceUpdateVMButton.addActionListener(new ActionListener() {
                                 
                                 @Override
                                 public void actionPerformed(ActionEvent e)
                                 {
                                    UpdateVMPanel.remove(NoSpaceUpdateVMPanel);
                                    
                                 }

                                });
                                
                           }else
                           {
                              CLI.updateVM(IDforupdate, cpu, ram, software, ssd, bandwidth, gpu);
                           }
  
                           CLI.updateremaining(cpu, ram, ssd, bandwidth, gpu);

                           UpdateVMPanel.revalidate();
                           UpdateVMPanel.repaint();
                        }
                       });
                     }
                    }                 
               }
            });
         }
      });
     
      ButtonBuilder DeleteVMButton = new ButtonBuilder("Delete VM", 45, 15);
      //----> kodikas gia delete
      DeleteVMButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            DeleteVMButton.setEnabled(false);

            LableBuilder DeleteVMlabel1 = new LableBuilder("Enter ID of VM you want to delete:", 0, 41);
            DeleteVMPanel.add(DeleteVMlabel1);

            TextFieldBuilder DeleteVMtext = new TextFieldBuilder(145, 41);
            DeleteVMPanel.add(DeleteVMtext);

            DeleteVMPanel.revalidate();
            DeleteVMPanel.repaint();


            DeleteVMtext.addActionListener(new ActionListener()
            {
               @Override
               public void actionPerformed(ActionEvent e)
               {
            
                     String deleteIDinput = DeleteVMtext.getText();
                     Scanner Deletescanner = new Scanner(deleteIDinput);

                     int IDfordelete = Deletescanner.nextInt();

                     DeleteVMPanel.revalidate();
                     DeleteVMPanel.repaint();

                     Deletescanner.close();

                     DeleteVMtext.setEnabled(false);
            
                     for(int i=0;i<CLI.VMs.size();i++)
                    {

                     if(IDfordelete == CLI.VMs.get(i).getVmId())
                     {

                        CLI.delete(IDfordelete);

                        LableBuilder UpdateVMlabel2 = new LableBuilder("VM got Deleted!", 0, 55);
                        UpdateVMPanel.add(UpdateVMlabel2);

                        DeleteVMPanel.revalidate();
                        DeleteVMPanel.repaint();

                     }

                     DeleteVMPanel.revalidate();
                     DeleteVMPanel.repaint();
                     

                    }

               }
            });
         }

      });

      ButtonBuilder ReportVMButton = new ButtonBuilder("Report VMs", 60, 15);
      //----> kodikas gia report
      ReportVMButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            ReportVMButton.setEnabled(false);

            LableBuilder ReportVMlabel1 = new LableBuilder("Enter 0 for single report or 1 for Full report:", 0, 41);
            ReportVMPanel.add(ReportVMlabel1);

            TextFieldBuilder ReportVMtext1 = new TextFieldBuilder(180, 40);
            ReportVMPanel.add(ReportVMtext1);

            ReportVMPanel.revalidate();
            ReportVMPanel.repaint();

            ReportVMtext1.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e)
               {

                  ReportVMtext1.setEnabled(false);

                  String choice = ReportVMtext1.getText();
                  Scanner idreportScanner = new Scanner(choice);

                  int choiceInput = idreportScanner.nextInt();

                  idreportScanner.close();
                  
                  ReportVMPanel.revalidate();
                  ReportVMPanel.repaint();
                 
                  
                  if(choiceInput == 0)
                  {
                     LableBuilder ReportVMlabel2 = new LableBuilder("Enter ID of VM you want to report:", 0, 55);
                     ReportVMPanel.add(ReportVMlabel2);

                     TextFieldBuilder ReportVMtext2 = new TextFieldBuilder(145, 55);
                     ReportVMPanel.add(ReportVMtext2);

                     ReportVMPanel.revalidate();
                     ReportVMPanel.repaint();

                     ReportVMtext2.addActionListener(new ActionListener() {
                        
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                           ReportVMtext2.setEnabled(false);

                           String idforreport = ReportVMtext2.getText();
                           Scanner reportscanner = new Scanner(idforreport);

                           int reportId = reportscanner.nextInt();

                           reportscanner.close();

                           ReportVMPanel.revalidate();
                           ReportVMPanel.repaint();

                           for (int i = 0; i < CLI.VMs.size(); i++) {

                              if (reportId == CLI.VMs.get(i).getVmId()) {
                      
                                if (CLI.VMs.get(i) instanceof VM) {
                                  String reportVMinfo = CLI.VMs.get(i).getVMCPU() + " " + CLI.VMs.get(i).getVMRAM() + " " + CLI.VMs.get(i).getVMSoftware() ;
                                  LableBuilder reportOneVM = new LableBuilder(reportVMinfo, 0, 69);
                                  ReportVMPanel.add(reportOneVM);
                                }
                                if (CLI.VMs.get(i) instanceof PlainVM) {
                                  String reportVMinfo = " " + ((PlainVM) CLI.VMs.get(i)).getPlainSSD() ;
                                  LableBuilder reportOneVM =new LableBuilder(reportVMinfo, 0, 69);
                                  ReportVMPanel.add(reportOneVM);
                                }
                                if (CLI.VMs.get(i) instanceof VmGPU) {
                                  String reportVMinfo = " " + ((VmGPU) CLI.VMs.get(i)).getVMGPU();
                                  LableBuilder reportOneVM = new LableBuilder(reportVMinfo, 0, 69);
                                  ReportVMPanel.add(reportOneVM);
                                }
                                if (CLI.VMs.get(i) instanceof VMNetworked) {
                                  String reportVMinfo = " " + ((VMNetworked) CLI.VMs.get(i)).getBandwidth() ;
                                  LableBuilder reportOneVM = new LableBuilder(reportVMinfo, 0, 69);
                                  ReportVMPanel.add(reportOneVM);
                                }
                                if (CLI.VMs.get(i) instanceof VMNetworkedGPU) {
                                  String reportVMinfo = " " + ((VMNetworkedGPU) CLI.VMs.get(i)).getNetGPU() ;
                                  LableBuilder reportOneVM = new LableBuilder(reportVMinfo, 0, 69);
                                  ReportVMPanel.add(reportOneVM);
                                }
                      
                              }
                      
                            }


                        }

                     });

                  }else if(choiceInput == 1)
                  {

                     for (int j = 0; j < CLI.VMs.size(); j++) {

                        int p =69;
                        p += 14*j;
                
                
                        if (CLI.VMs.get(j) instanceof VM) {
                           String reportinfo = CLI.VMs.get(j).getVMCPU() + " " + CLI.VMs.get(j).getVMRAM() + " " + CLI.VMs.get(j).getVMSoftware() ; 
                           LableBuilder reportAllVM = new LableBuilder(reportinfo, 0, p);
                           ReportVMPanel.add(reportAllVM);
                
                        }
                        if (CLI.VMs.get(j) instanceof PlainVM) {
                           String reportinfo = " " + ((PlainVM) CLI.VMs.get(j)).getPlainSSD() ; 
                          
                          LableBuilder reportAllVM = new LableBuilder(reportinfo, 0, p);
                          ReportVMPanel.add(reportAllVM);
                        }
                        if (CLI.VMs.get(j) instanceof VmGPU) {
                           String reportinfo = " " + ((VmGPU) CLI.VMs.get(j)).getVMGPU() ;
                          
                          LableBuilder reportAllVM = new LableBuilder(reportinfo, 0, p);
                          ReportVMPanel.add(reportAllVM);
                        }
                        if (CLI.VMs.get(j) instanceof VMNetworked) {
                           String reportinfo = " " + ((VMNetworked) CLI.VMs.get(j)).getBandwidth() ; 
                          
                          LableBuilder reportAllVM = new LableBuilder(reportinfo, 0, p);
                          ReportVMPanel.add(reportAllVM);
                        }
                        if (CLI.VMs.get(j) instanceof VMNetworkedGPU) {
                           String reportinfo = " " + ((VMNetworkedGPU) CLI.VMs.get(j)).getNetGPU(); 
                          
                          LableBuilder reportAllVM = new LableBuilder(reportinfo, 0, p);
                          ReportVMPanel.add(reportAllVM);
                        }
                
                      }

                  }

                  ReportVMPanel.revalidate();
                  ReportVMPanel.repaint();

               }

            });

            
         }
      });

      ButtonBuilder DoneVMButton = new ButtonBuilder("Next", 50, 105);
      //---> kodikas gia epomeno frame
      DoneVMButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            InitialFrame.dispose();


            FrameBuilder SecondFrame = new FrameBuilder("Program software");



            PanelBuilder CreateProgramPanel = new PanelBuilder(0, 0, 315, 145);
     CreateProgramPanel.setBackground(Color.DARK_GRAY);
     PanelBuilder CreateProgramPanel2 = new PanelBuilder(0, 145, 715, 725);
     CreateProgramPanel2.setBackground(Color.DARK_GRAY);
     PanelBuilder DoneProgramPanel = new PanelBuilder(335, 0, 315, 130);
     DoneProgramPanel.setBackground(Color.DARK_GRAY);
     PanelBuilder NoSpaceProgramPanel = new PanelBuilder(20, 100, 600, 110);
     NoSpaceProgramPanel.setBackground(Color.GRAY);

     ButtonBuilder CreateProgramButton = new ButtonBuilder("Create Program", 75, 35);
     CreateProgramButton.setSize(150, 30);
     //---> kodikas gia create Program

     CreateProgramButton.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {

         CreateProgramButton.setEnabled(false);

         LableBuilder CreateProgramlabel1 = new LableBuilder("Enter number of Programs for creation:", 0, 0);
         CreateProgramPanel2.add(CreateProgramlabel1);

         TextFieldBuilder NumofProgramText = new TextFieldBuilder(160, 0);
         CreateProgramPanel2.add(NumofProgramText);

         CreateProgramPanel2.revalidate();
         CreateProgramPanel2.repaint();

         NumofProgramText.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
               NumofProgramText.setEnabled(false);

               String numofPrograms = NumofProgramText.getText();
               Scanner numofprojScanner = new Scanner(numofPrograms);
               int projNum = numofprojScanner.nextInt();
               numofprojScanner.close();

               for(int i=0;i<projNum;i++)
               {
                  int k = 14;
                  k += 14*i;

                  LableBuilder CreateProgramlabel2 = new LableBuilder("Enter in format (CPU, RAM, SSD, GPU, Bandwidth, ExpectedTime):", 0, k);
                  CreateProgramPanel2.add(CreateProgramlabel2);

                  TextFieldBuilder ProgramCorestext = new TextFieldBuilder(290, k);
                  CreateProgramPanel2.add(ProgramCorestext);

                  CreateProgramPanel2.revalidate();
                  CreateProgramPanel2.repaint();

                  ProgramCorestext.addActionListener(new ActionListener() {
                  
                     @Override
                     public void actionPerformed(ActionEvent e)
                     {
   
                        ProgramCorestext.setEnabled(false);

                        String Programinfo = ProgramCorestext.getText();
                        Scanner ProgramcoreScanner = new Scanner(Programinfo);
                        ProgramcoreScanner.useDelimiter(",\\s*");

                        int cores = Integer.parseInt(ProgramcoreScanner.next());
                        int ram =Integer.parseInt(ProgramcoreScanner.next());
                        int ssd = Integer.parseInt(ProgramcoreScanner.next());
                        int gpu = Integer.parseInt(ProgramcoreScanner.next());
                        int bandwidth = Integer.parseInt(ProgramcoreScanner.next());
                        int expectedtime = Integer.parseInt(ProgramcoreScanner.next());

                        ProgramcoreScanner.close();

                        CLI.createProgram(cores, ram, ssd, gpu, bandwidth, expectedtime);

   
                        CreateProgramPanel2.revalidate();
                        CreateProgramPanel2.repaint();
                     }
   
                  });

               }

               CreateProgramPanel2.revalidate();
               CreateProgramPanel2.repaint();



            }

         });

         

      }

     });

     ButtonBuilder DoneProgramButton = new ButtonBuilder("Next", 100, 35);
     //-----> kodikas gia epomeno frame
     DoneProgramButton.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e)
      {
         DoneProgramButton.setEnabled(false);
         SecondFrame.dispose();

         FrameBuilder ThirdFrame = new FrameBuilder("Concluding...");

      

     PanelBuilder SortingPanel = new PanelBuilder(0, 0, 315, 130);
     SortingPanel.setBackground(Color.DARK_GRAY);

     LableBuilder Sortinglabel1 = new LableBuilder("Loading VMs and Programs.....", 0, 00);
     SortingPanel.add(Sortinglabel1);
     LableBuilder Sortinglabel2 = new LableBuilder("Sorting.....", 0, 20);
     SortingPanel.add(Sortinglabel2);
     LableBuilder Sortinglabel3 = new LableBuilder("Done!", 0, 40);
     SortingPanel.add(Sortinglabel3);


     ThirdFrame.add(SortingPanel); 

     ButtonBuilder FinishSortingButton = new ButtonBuilder("Finish", 100, 85);
     SortingPanel.add(FinishSortingButton);
     //---> kodikas pou emfanizei to teleutaio panel
     FinishSortingButton.addActionListener(new ActionListener() {
      
      @Override 
      public void actionPerformed(ActionEvent e)
      {
         FinishSortingButton.setEnabled(false);

         SortingPanel.revalidate();
         SortingPanel.repaint();

         PanelBuilder AllDonePanel = new PanelBuilder(335, 0, 315, 130);
         AllDonePanel.setBackground(Color.DARK_GRAY);
         ThirdFrame.add(AllDonePanel);

         LableBuilder AllDonelabel1 = new LableBuilder("Finished!", 0, 40);
         AllDonePanel.add(AllDonelabel1);

         ButtonBuilder ExitSoftwareButton = new ButtonBuilder("Exit", 100, 85);
         AllDonePanel.add(ExitSoftwareButton);

         ThirdFrame.revalidate();
         ThirdFrame.repaint();

         ExitSoftwareButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
               ThirdFrame.dispose();
            }

         });




      }

     });
     
     

     //if(Programs rejected)
     {
         PanelBuilder RejectedProgramPanel = new PanelBuilder(0, 145, 715, 725);
         RejectedProgramPanel.setBackground(Color.DARK_GRAY);
         ThirdFrame.add(RejectedProgramPanel);

         LableBuilder Rejectedlabel1 = new LableBuilder("These Programs got rejected and placed on the File:", 0, 0);
         RejectedProgramPanel.add(Rejectedlabel1);

         //---> kodikas pou pernai id ton Programs pou eginan rrejected kai ta bazei na kanoun print me loop messenger

         ButtonBuilder RejectedButton = new ButtonBuilder("Ok", 450, 370);
         RejectedProgramPanel.add(RejectedButton);
         RejectedButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
               ThirdFrame.remove(RejectedProgramPanel);

               ThirdFrame.revalidate();
               ThirdFrame.repaint();
            }

         });

         


       
      }

     

      }

     });

     CreateProgramPanel.add(CreateProgramButton);
     DoneProgramPanel.add(DoneProgramButton);

     
     SecondFrame.add(CreateProgramPanel);
     SecondFrame.add(DoneProgramPanel);
     SecondFrame.add(CreateProgramPanel2);
     


         }


      });
 
      
 
      CreateVMPanel.add(CreateVMButton);
      UpdateVMPanel.add(UpdateVMButton);
      ReportVMPanel.add(ReportVMButton);
      DoneVMPanel.add(DoneVMButton);
      DeleteVMPanel.add(DeleteVMButton);
 

      
 
      CreateVMPanel.setBackground(Color.DARK_GRAY);
      DeleteVMPanel.setBackground(Color.DARK_GRAY);
      UpdateVMPanel.setBackground(Color.DARK_GRAY);
      ReportVMPanel.setBackground(Color.DARK_GRAY);
      DoneVMPanel.setBackground(Color.DARK_GRAY);
      NoSpaceVMPanel.setBackground(Color.GRAY);
      NoSpaceUpdateVMPanel.setBackground(Color.GRAY);
 
      InitialFrame.add(CreateVMPanel);
      InitialFrame.add(UpdateVMPanel);
      InitialFrame.add(DeleteVMPanel);
      InitialFrame.add(ReportVMPanel);
      InitialFrame.add(DoneVMPanel);
    
     

   }
 
 }

}
