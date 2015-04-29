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
         this.dataGridView1 = new System.Windows.Forms.DataGridView();
         this.DateHeure = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.Section = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.NbrePlace = new System.Windows.Forms.DataGridViewTextBoxColumn();
         ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
         this.SuspendLayout();
         // 
         // BTN_Fermer
         // 
         this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Fermer.Location = new System.Drawing.Point(142, 362);
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
         this.CB_Spectacle.Location = new System.Drawing.Point(184, 28);
         this.CB_Spectacle.Name = "CB_Spectacle";
         this.CB_Spectacle.Size = new System.Drawing.Size(166, 21);
         this.CB_Spectacle.TabIndex = 3;
         // 
         // CB_Salle
         // 
         this.CB_Salle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Salle.FormattingEnabled = true;
         this.CB_Salle.Location = new System.Drawing.Point(8, 28);
         this.CB_Salle.Name = "CB_Salle";
         this.CB_Salle.Size = new System.Drawing.Size(166, 21);
         this.CB_Salle.TabIndex = 4;
         // 
         // label1
         // 
         this.label1.AutoSize = true;
         this.label1.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label1.Location = new System.Drawing.Point(56, 7);
         this.label1.Name = "label1";
         this.label1.Size = new System.Drawing.Size(73, 17);
         this.label1.TabIndex = 5;
         this.label1.Text = "Spectacle";
         // 
         // label2
         // 
         this.label2.AutoSize = true;
         this.label2.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label2.Location = new System.Drawing.Point(220, 7);
         this.label2.Name = "label2";
         this.label2.Size = new System.Drawing.Size(97, 17);
         this.label2.TabIndex = 6;
         this.label2.Text = "Date et heure";
         // 
         // dataGridView1
         // 
         this.dataGridView1.AllowUserToAddRows = false;
         this.dataGridView1.AllowUserToDeleteRows = false;
         this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
         this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.DateHeure,
            this.Section,
            this.NbrePlace});
         this.dataGridView1.Location = new System.Drawing.Point(8, 54);
         this.dataGridView1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.dataGridView1.Name = "dataGridView1";
         this.dataGridView1.ReadOnly = true;
         this.dataGridView1.RowHeadersVisible = false;
         this.dataGridView1.RowTemplate.Height = 24;
         this.dataGridView1.Size = new System.Drawing.Size(342, 302);
         this.dataGridView1.TabIndex = 7;
         // 
         // DateHeure
         // 
         this.DateHeure.HeaderText = "Date et Heure";
         this.DateHeure.Name = "DateHeure";
         this.DateHeure.ReadOnly = true;
         this.DateHeure.Width = 110;
         // 
         // Section
         // 
         this.Section.HeaderText = "Section";
         this.Section.Name = "Section";
         this.Section.ReadOnly = true;
         this.Section.Width = 110;
         // 
         // NbrePlace
         // 
         this.NbrePlace.HeaderText = "Places disponibles";
         this.NbrePlace.Name = "NbrePlace";
         this.NbrePlace.ReadOnly = true;
         this.NbrePlace.Width = 110;
         // 
         // ConsultationPlaces
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(356, 396);
         this.Controls.Add(this.dataGridView1);
         this.Controls.Add(this.label2);
         this.Controls.Add(this.label1);
         this.Controls.Add(this.CB_Salle);
         this.Controls.Add(this.CB_Spectacle);
         this.Controls.Add(this.BTN_Fermer);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.Name = "ConsultationPlaces";
         this.Text = "ConsultationPlaces";
         ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
         this.ResumeLayout(false);
         this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
        private System.Windows.Forms.ComboBox CB_Spectacle;
        private System.Windows.Forms.ComboBox CB_Salle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn DateHeure;
        private System.Windows.Forms.DataGridViewTextBoxColumn Section;
        private System.Windows.Forms.DataGridViewTextBoxColumn NbrePlace;
    }
}