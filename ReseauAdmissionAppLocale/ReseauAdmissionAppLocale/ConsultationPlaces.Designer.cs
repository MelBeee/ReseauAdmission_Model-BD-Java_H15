namespace ReseauAdmissionAppLocale
{
    partial class ConsultationPlaces
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
         this.CB_Spectacle = new System.Windows.Forms.ComboBox();
         this.CB_Salle = new System.Windows.Forms.ComboBox();
         this.label1 = new System.Windows.Forms.Label();
         this.label2 = new System.Windows.Forms.Label();
         this.SuspendLayout();
         // 
         // BTN_Fermer
         // 
         this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Fermer.Location = new System.Drawing.Point(162, 361);
         this.BTN_Fermer.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.BTN_Fermer.Name = "BTN_Fermer";
         this.BTN_Fermer.Size = new System.Drawing.Size(72, 27);
         this.BTN_Fermer.TabIndex = 2;
         this.BTN_Fermer.Text = "Fermer";
         this.BTN_Fermer.UseVisualStyleBackColor = true;
         this.BTN_Fermer.Click += new System.EventHandler(this.BTN_Fermer_Click);
         // 
         // CB_Spectacle
         // 
         this.CB_Spectacle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Spectacle.FormattingEnabled = true;
         this.CB_Spectacle.Location = new System.Drawing.Point(8, 28);
         this.CB_Spectacle.Name = "CB_Spectacle";
         this.CB_Spectacle.Size = new System.Drawing.Size(187, 21);
         this.CB_Spectacle.TabIndex = 3;
         // 
         // CB_Salle
         // 
         this.CB_Salle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Salle.FormattingEnabled = true;
         this.CB_Salle.Location = new System.Drawing.Point(201, 28);
         this.CB_Salle.Name = "CB_Salle";
         this.CB_Salle.Size = new System.Drawing.Size(187, 21);
         this.CB_Salle.TabIndex = 4;
         // 
         // label1
         // 
         this.label1.AutoSize = true;
         this.label1.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label1.Location = new System.Drawing.Point(65, 8);
         this.label1.Name = "label1";
         this.label1.Size = new System.Drawing.Size(73, 17);
         this.label1.TabIndex = 5;
         this.label1.Text = "Spectacle";
         // 
         // label2
         // 
         this.label2.AutoSize = true;
         this.label2.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label2.Location = new System.Drawing.Point(271, 8);
         this.label2.Name = "label2";
         this.label2.Size = new System.Drawing.Size(46, 17);
         this.label2.TabIndex = 6;
         this.label2.Text = "Salle";
         // 
         // ConsultationPlaces
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(396, 396);
         this.Controls.Add(this.label2);
         this.Controls.Add(this.label1);
         this.Controls.Add(this.CB_Salle);
         this.Controls.Add(this.CB_Spectacle);
         this.Controls.Add(this.BTN_Fermer);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.Name = "ConsultationPlaces";
         this.Text = "ConsultationPlaces";
         this.Load += new System.EventHandler(this.ConsultationPlaces_Load);
         this.ResumeLayout(false);
         this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
        private System.Windows.Forms.ComboBox CB_Spectacle;
        private System.Windows.Forms.ComboBox CB_Salle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
    }
}