namespace ReseauAdmissionAppLocale
{
   partial class rootForm
   {
      /// <summary>
      /// Required designer variable.
      /// </summary>
      private System.ComponentModel.IContainer components = null;

      /// <summary>
      /// Clean up any resources being used.
      /// </summary>
      /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
      protected override void Dispose(bool disposing)
      {
         if (disposing && (components != null))
         {
            components.Dispose();
         }
         base.Dispose(disposing);
      }

      #region Windows Form Designer generated code

      /// <summary>
      /// Required method for Designer support - do not modify
      /// the contents of this method with the code editor.
      /// </summary>
      private void InitializeComponent()
      {
         this.panel2 = new System.Windows.Forms.Panel();
         this.panel3 = new System.Windows.Forms.Panel();
         this.panel4 = new System.Windows.Forms.Panel();
         this.panel5 = new System.Windows.Forms.Panel();
         this.panel6 = new System.Windows.Forms.Panel();
         this.SuspendLayout();
         // 
         // panel2
         // 
         this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(221)))), ((int)(((byte)(155)))));
         this.panel2.Location = new System.Drawing.Point(12, 9);
         this.panel2.Name = "panel2";
         this.panel2.Size = new System.Drawing.Size(200, 200);
         this.panel2.TabIndex = 0;
         this.panel2.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panel1_MouseDown);
         this.panel2.MouseEnter += new System.EventHandler(this.panel1_MouseEnter);
         this.panel2.MouseLeave += new System.EventHandler(this.panel1_MouseLeave);
         this.panel2.MouseUp += new System.Windows.Forms.MouseEventHandler(this.panel1_MouseUp);
         // 
         // panel3
         // 
         this.panel3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(221)))), ((int)(((byte)(155)))));
         this.panel3.Location = new System.Drawing.Point(218, 9);
         this.panel3.Name = "panel3";
         this.panel3.Size = new System.Drawing.Size(200, 200);
         this.panel3.TabIndex = 1;
         this.panel3.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panel2_MouseDown);
         this.panel3.MouseEnter += new System.EventHandler(this.panel2_MouseEnter);
         this.panel3.MouseLeave += new System.EventHandler(this.panel2_MouseLeave);
         this.panel3.MouseUp += new System.Windows.Forms.MouseEventHandler(this.panel2_MouseUp);
         // 
         // panel4
         // 
         this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(221)))), ((int)(((byte)(155)))));
         this.panel4.Location = new System.Drawing.Point(424, 9);
         this.panel4.Name = "panel4";
         this.panel4.Size = new System.Drawing.Size(200, 200);
         this.panel4.TabIndex = 1;
         this.panel4.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panel3_MouseDown);
         this.panel4.MouseEnter += new System.EventHandler(this.panel3_MouseEnter);
         this.panel4.MouseLeave += new System.EventHandler(this.panel3_MouseLeave);
         this.panel4.MouseUp += new System.Windows.Forms.MouseEventHandler(this.panel3_MouseUp);
         // 
         // panel5
         // 
         this.panel5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(221)))), ((int)(((byte)(155)))));
         this.panel5.Location = new System.Drawing.Point(12, 215);
         this.panel5.Name = "panel5";
         this.panel5.Size = new System.Drawing.Size(303, 200);
         this.panel5.TabIndex = 3;
         this.panel5.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panel4_MouseDown);
         this.panel5.MouseEnter += new System.EventHandler(this.panel4_MouseEnter);
         this.panel5.MouseLeave += new System.EventHandler(this.panel4_MouseLeave);
         this.panel5.MouseUp += new System.Windows.Forms.MouseEventHandler(this.panel4_MouseUp);
         // 
         // panel6
         // 
         this.panel6.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(221)))), ((int)(((byte)(155)))));
         this.panel6.Location = new System.Drawing.Point(321, 215);
         this.panel6.Name = "panel6";
         this.panel6.Size = new System.Drawing.Size(303, 200);
         this.panel6.TabIndex = 4;
         this.panel6.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panel5_MouseDown);
         this.panel6.MouseEnter += new System.EventHandler(this.panel5_MouseEnter);
         this.panel6.MouseLeave += new System.EventHandler(this.panel5_MouseLeave);
         this.panel6.MouseUp += new System.Windows.Forms.MouseEventHandler(this.panel5_MouseUp);
         // 
         // rootForm
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(634, 423);
         this.Controls.Add(this.panel6);
         this.Controls.Add(this.panel5);
         this.Controls.Add(this.panel4);
         this.Controls.Add(this.panel3);
         this.Controls.Add(this.panel2);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Name = "rootForm";
         this.Text = "ReseauAdmission";
         this.Load += new System.EventHandler(this.rootForm_Load);
         this.ResumeLayout(false);

      }

      #endregion

      private System.Windows.Forms.Panel panel2;
      private System.Windows.Forms.Panel panel3;
      private System.Windows.Forms.Panel panel4;
      private System.Windows.Forms.Panel panel5;
      private System.Windows.Forms.Panel panel6;
   }
}