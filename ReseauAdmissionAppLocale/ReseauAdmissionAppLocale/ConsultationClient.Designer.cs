namespace ReseauAdmissionAppLocale
{
    partial class ConsultationClient
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
         this.BTN_Fermer = new System.Windows.Forms.Button();
         this.SuspendLayout();
         // 
         // BTN_Fermer
         // 
         this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Fermer.Location = new System.Drawing.Point(70, 90);
         this.BTN_Fermer.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.BTN_Fermer.Name = "BTN_Fermer";
         this.BTN_Fermer.Size = new System.Drawing.Size(72, 27);
         this.BTN_Fermer.TabIndex = 2;
         this.BTN_Fermer.Text = "Fermer";
         this.BTN_Fermer.UseVisualStyleBackColor = true;
         this.BTN_Fermer.Click += new System.EventHandler(this.BTN_Fermer_Click);
         // 
         // ConsultationClient
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(212, 207);
         this.Controls.Add(this.BTN_Fermer);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.Name = "ConsultationClient";
         this.Text = "ConsultationClient";
         this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
    }
}