namespace ReseauAdmissionAppLocale
{
    partial class Representation
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
         this.label1 = new System.Windows.Forms.Label();
         this.label2 = new System.Windows.Forms.Label();
         this.CB_Salle = new System.Windows.Forms.ComboBox();
         this.DTP_DateSpectacle = new System.Windows.Forms.DateTimePicker();
         this.groupBox1 = new System.Windows.Forms.GroupBox();
         this.CB_Spectacle = new System.Windows.Forms.ComboBox();
         this.label6 = new System.Windows.Forms.Label();
         this.BTN_AjouterHeureSalle = new System.Windows.Forms.Button();
         this.BTN_Quitter = new System.Windows.Forms.Button();
         this.CB_Section = new System.Windows.Forms.ComboBox();
         this.TB_Prix = new System.Windows.Forms.TextBox();
         this.label3 = new System.Windows.Forms.Label();
         this.label4 = new System.Windows.Forms.Label();
         this.BTN_AjouterSectionPrix = new System.Windows.Forms.Button();
         this.groupBox2 = new System.Windows.Forms.GroupBox();
         this.LB_Attention = new System.Windows.Forms.Label();
         this.groupBox1.SuspendLayout();
         this.groupBox2.SuspendLayout();
         this.SuspendLayout();
         // 
         // label1
         // 
         this.label1.AutoSize = true;
         this.label1.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label1.Location = new System.Drawing.Point(28, 50);
         this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label1.Name = "label1";
         this.label1.Size = new System.Drawing.Size(48, 15);
         this.label1.TabIndex = 0;
         this.label1.Text = "Date : ";
         // 
         // label2
         // 
         this.label2.AutoSize = true;
         this.label2.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label2.Location = new System.Drawing.Point(22, 80);
         this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label2.Name = "label2";
         this.label2.Size = new System.Drawing.Size(52, 15);
         this.label2.TabIndex = 1;
         this.label2.Text = "Salle : ";
         // 
         // CB_Salle
         // 
         this.CB_Salle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Salle.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.CB_Salle.FormattingEnabled = true;
         this.CB_Salle.Location = new System.Drawing.Point(74, 76);
         this.CB_Salle.Margin = new System.Windows.Forms.Padding(2);
         this.CB_Salle.Name = "CB_Salle";
         this.CB_Salle.Size = new System.Drawing.Size(181, 23);
         this.CB_Salle.TabIndex = 3;
         this.CB_Salle.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
         // 
         // DTP_DateSpectacle
         // 
         this.DTP_DateSpectacle.CustomFormat = "yyyy-MM-dd HH:MM:ss";
         this.DTP_DateSpectacle.Font = new System.Drawing.Font("Book Antiqua", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.DTP_DateSpectacle.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
         this.DTP_DateSpectacle.Location = new System.Drawing.Point(74, 47);
         this.DTP_DateSpectacle.Margin = new System.Windows.Forms.Padding(2);
         this.DTP_DateSpectacle.MaxDate = new System.DateTime(2100, 5, 3, 0, 0, 0, 0);
         this.DTP_DateSpectacle.MinDate = new System.DateTime(2015, 5, 3, 0, 0, 0, 0);
         this.DTP_DateSpectacle.Name = "DTP_DateSpectacle";
         this.DTP_DateSpectacle.Size = new System.Drawing.Size(181, 24);
         this.DTP_DateSpectacle.TabIndex = 4;
         this.DTP_DateSpectacle.Value = new System.DateTime(2015, 5, 3, 0, 0, 0, 0);
         this.DTP_DateSpectacle.ValueChanged += new System.EventHandler(this.DTP_DateSpectacle_ValueChanged);
         // 
         // groupBox1
         // 
         this.groupBox1.Controls.Add(this.CB_Spectacle);
         this.groupBox1.Controls.Add(this.label6);
         this.groupBox1.Controls.Add(this.BTN_AjouterHeureSalle);
         this.groupBox1.Controls.Add(this.label1);
         this.groupBox1.Controls.Add(this.DTP_DateSpectacle);
         this.groupBox1.Controls.Add(this.label2);
         this.groupBox1.Controls.Add(this.CB_Salle);
         this.groupBox1.Font = new System.Drawing.Font("Forte", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.groupBox1.ForeColor = System.Drawing.Color.Black;
         this.groupBox1.Location = new System.Drawing.Point(9, 10);
         this.groupBox1.Margin = new System.Windows.Forms.Padding(2);
         this.groupBox1.Name = "groupBox1";
         this.groupBox1.Padding = new System.Windows.Forms.Padding(2);
         this.groupBox1.Size = new System.Drawing.Size(268, 140);
         this.groupBox1.TabIndex = 5;
         this.groupBox1.TabStop = false;
         this.groupBox1.Text = "Où, Quand et Quoi";
         // 
         // CB_Spectacle
         // 
         this.CB_Spectacle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Spectacle.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.CB_Spectacle.FormattingEnabled = true;
         this.CB_Spectacle.Location = new System.Drawing.Point(74, 20);
         this.CB_Spectacle.Margin = new System.Windows.Forms.Padding(2);
         this.CB_Spectacle.Name = "CB_Spectacle";
         this.CB_Spectacle.Size = new System.Drawing.Size(181, 23);
         this.CB_Spectacle.TabIndex = 15;
         // 
         // label6
         // 
         this.label6.AutoSize = true;
         this.label6.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label6.Location = new System.Drawing.Point(2, 22);
         this.label6.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label6.Name = "label6";
         this.label6.Size = new System.Drawing.Size(75, 15);
         this.label6.TabIndex = 14;
         this.label6.Text = "Spectacle : ";
         // 
         // BTN_AjouterHeureSalle
         // 
         this.BTN_AjouterHeureSalle.Font = new System.Drawing.Font("Forte", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.BTN_AjouterHeureSalle.Location = new System.Drawing.Point(93, 105);
         this.BTN_AjouterHeureSalle.Margin = new System.Windows.Forms.Padding(2);
         this.BTN_AjouterHeureSalle.Name = "BTN_AjouterHeureSalle";
         this.BTN_AjouterHeureSalle.Size = new System.Drawing.Size(82, 24);
         this.BTN_AjouterHeureSalle.TabIndex = 13;
         this.BTN_AjouterHeureSalle.Text = "Ajouter";
         this.BTN_AjouterHeureSalle.UseVisualStyleBackColor = true;
         this.BTN_AjouterHeureSalle.Click += new System.EventHandler(this.BTN_AjouterHeureSalle_Click);
         // 
         // BTN_Quitter
         // 
         this.BTN_Quitter.Font = new System.Drawing.Font("Forte", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.BTN_Quitter.Location = new System.Drawing.Point(112, 297);
         this.BTN_Quitter.Margin = new System.Windows.Forms.Padding(2);
         this.BTN_Quitter.Name = "BTN_Quitter";
         this.BTN_Quitter.Size = new System.Drawing.Size(64, 24);
         this.BTN_Quitter.TabIndex = 7;
         this.BTN_Quitter.Text = "Fermer";
         this.BTN_Quitter.UseVisualStyleBackColor = true;
         this.BTN_Quitter.Click += new System.EventHandler(this.button2_Click);
         // 
         // CB_Section
         // 
         this.CB_Section.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Section.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.CB_Section.FormattingEnabled = true;
         this.CB_Section.Location = new System.Drawing.Point(62, 21);
         this.CB_Section.Margin = new System.Windows.Forms.Padding(2);
         this.CB_Section.Name = "CB_Section";
         this.CB_Section.Size = new System.Drawing.Size(193, 23);
         this.CB_Section.TabIndex = 8;
         this.CB_Section.SelectedIndexChanged += new System.EventHandler(this.CB_Section_SelectedIndexChanged);
         // 
         // TB_Prix
         // 
         this.TB_Prix.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.TB_Prix.Location = new System.Drawing.Point(62, 48);
         this.TB_Prix.Margin = new System.Windows.Forms.Padding(2);
         this.TB_Prix.MaxLength = 6;
         this.TB_Prix.Name = "TB_Prix";
         this.TB_Prix.Size = new System.Drawing.Size(193, 26);
         this.TB_Prix.TabIndex = 9;
         this.TB_Prix.TextChanged += new System.EventHandler(this.TB_Prix_TextChanged);
         this.TB_Prix.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.TB_Prix_KeyPress);
         // 
         // label3
         // 
         this.label3.AutoSize = true;
         this.label3.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label3.Location = new System.Drawing.Point(4, 24);
         this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label3.Name = "label3";
         this.label3.Size = new System.Drawing.Size(57, 15);
         this.label3.TabIndex = 10;
         this.label3.Text = "Section :";
         // 
         // label4
         // 
         this.label4.AutoSize = true;
         this.label4.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label4.Location = new System.Drawing.Point(21, 53);
         this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label4.Name = "label4";
         this.label4.Size = new System.Drawing.Size(39, 15);
         this.label4.TabIndex = 11;
         this.label4.Text = "Prix :";
         // 
         // BTN_AjouterSectionPrix
         // 
         this.BTN_AjouterSectionPrix.Font = new System.Drawing.Font("Forte", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.BTN_AjouterSectionPrix.Location = new System.Drawing.Point(93, 78);
         this.BTN_AjouterSectionPrix.Margin = new System.Windows.Forms.Padding(2);
         this.BTN_AjouterSectionPrix.Name = "BTN_AjouterSectionPrix";
         this.BTN_AjouterSectionPrix.Size = new System.Drawing.Size(82, 24);
         this.BTN_AjouterSectionPrix.TabIndex = 12;
         this.BTN_AjouterSectionPrix.Text = "Ajouter";
         this.BTN_AjouterSectionPrix.UseVisualStyleBackColor = true;
         this.BTN_AjouterSectionPrix.Click += new System.EventHandler(this.BTN_AjouterSectionPrix_Click);
         // 
         // groupBox2
         // 
         this.groupBox2.Controls.Add(this.label3);
         this.groupBox2.Controls.Add(this.BTN_AjouterSectionPrix);
         this.groupBox2.Controls.Add(this.CB_Section);
         this.groupBox2.Controls.Add(this.label4);
         this.groupBox2.Controls.Add(this.TB_Prix);
         this.groupBox2.Font = new System.Drawing.Font("Forte", 9F);
         this.groupBox2.Location = new System.Drawing.Point(9, 154);
         this.groupBox2.Margin = new System.Windows.Forms.Padding(2);
         this.groupBox2.Name = "groupBox2";
         this.groupBox2.Padding = new System.Windows.Forms.Padding(2);
         this.groupBox2.Size = new System.Drawing.Size(268, 110);
         this.groupBox2.TabIndex = 13;
         this.groupBox2.TabStop = false;
         this.groupBox2.Text = "Section et Prix";
         // 
         // LB_Attention
         // 
         this.LB_Attention.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.LB_Attention.ForeColor = System.Drawing.Color.DarkRed;
         this.LB_Attention.Location = new System.Drawing.Point(9, 274);
         this.LB_Attention.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.LB_Attention.Name = "LB_Attention";
         this.LB_Attention.Size = new System.Drawing.Size(268, 18);
         this.LB_Attention.TabIndex = 14;
         this.LB_Attention.Text = "Il faut mettre un prix à toutes les sections";
         this.LB_Attention.TextAlign = System.Drawing.ContentAlignment.TopCenter;
         // 
         // Representation
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(288, 327);
         this.Controls.Add(this.LB_Attention);
         this.Controls.Add(this.groupBox2);
         this.Controls.Add(this.BTN_Quitter);
         this.Controls.Add(this.groupBox1);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2);
         this.Name = "Representation";
         this.Text = "Nouvelle Representation";
         this.Load += new System.EventHandler(this.Representation_Load);
         this.groupBox1.ResumeLayout(false);
         this.groupBox1.PerformLayout();
         this.groupBox2.ResumeLayout(false);
         this.groupBox2.PerformLayout();
         this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox CB_Salle;
        private System.Windows.Forms.DateTimePicker DTP_DateSpectacle;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button BTN_Quitter;
        private System.Windows.Forms.ComboBox CB_Section;
        private System.Windows.Forms.TextBox TB_Prix;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button BTN_AjouterSectionPrix;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label LB_Attention;
        private System.Windows.Forms.Button BTN_AjouterHeureSalle;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.ComboBox CB_Spectacle;
    }
}