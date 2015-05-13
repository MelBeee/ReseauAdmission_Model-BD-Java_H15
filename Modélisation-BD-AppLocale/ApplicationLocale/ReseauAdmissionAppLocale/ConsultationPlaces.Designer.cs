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
         this.CB_Salle = new System.Windows.Forms.ComboBox();
         this.label1 = new System.Windows.Forms.Label();
         this.DGV_Place = new System.Windows.Forms.DataGridView();
         this.DateHeure = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.Section = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.NbrePlace = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.CB_IDSpectacle = new System.Windows.Forms.ComboBox();
         ((System.ComponentModel.ISupportInitialize)(this.DGV_Place)).BeginInit();
         this.SuspendLayout();
         // 
         // BTN_Fermer
         // 
         this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Fermer.Location = new System.Drawing.Point(142, 365);
         this.BTN_Fermer.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.BTN_Fermer.Name = "BTN_Fermer";
         this.BTN_Fermer.Size = new System.Drawing.Size(72, 27);
         this.BTN_Fermer.TabIndex = 2;
         this.BTN_Fermer.Text = "Fermer";
         this.BTN_Fermer.UseVisualStyleBackColor = true;
         this.BTN_Fermer.Click += new System.EventHandler(this.BTN_Fermer_Click);
         // 
         // CB_Salle
         // 
         this.CB_Salle.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Salle.FormattingEnabled = true;
         this.CB_Salle.Location = new System.Drawing.Point(8, 32);
         this.CB_Salle.Name = "CB_Salle";
         this.CB_Salle.Size = new System.Drawing.Size(342, 21);
         this.CB_Salle.TabIndex = 4;
         this.CB_Salle.SelectedIndexChanged += new System.EventHandler(this.CB_Salle_SelectedIndexChanged);
         // 
         // label1
         // 
         this.label1.Font = new System.Drawing.Font("Forte", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label1.Location = new System.Drawing.Point(8, 7);
         this.label1.Name = "label1";
         this.label1.Size = new System.Drawing.Size(342, 24);
         this.label1.TabIndex = 5;
         this.label1.Text = "Choisir un spectacle à consulter";
         this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
         // 
         // DGV_Place
         // 
         this.DGV_Place.AllowUserToDeleteRows = false;
         this.DGV_Place.AllowUserToResizeColumns = false;
         this.DGV_Place.AllowUserToResizeRows = false;
         this.DGV_Place.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
         this.DGV_Place.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.DateHeure,
            this.Section,
            this.NbrePlace});
         this.DGV_Place.Location = new System.Drawing.Point(8, 56);
         this.DGV_Place.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.DGV_Place.Name = "DGV_Place";
         this.DGV_Place.ReadOnly = true;
         this.DGV_Place.RowHeadersVisible = false;
         this.DGV_Place.RowTemplate.Height = 24;
         this.DGV_Place.Size = new System.Drawing.Size(342, 302);
         this.DGV_Place.TabIndex = 7;
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
         // CB_IDSpectacle
         // 
         this.CB_IDSpectacle.FormattingEnabled = true;
         this.CB_IDSpectacle.Location = new System.Drawing.Point(81, 106);
         this.CB_IDSpectacle.Name = "CB_IDSpectacle";
         this.CB_IDSpectacle.Size = new System.Drawing.Size(206, 21);
         this.CB_IDSpectacle.TabIndex = 8;
         // 
         // ConsultationPlaces
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(358, 396);
         this.Controls.Add(this.DGV_Place);
         this.Controls.Add(this.label1);
         this.Controls.Add(this.CB_Salle);
         this.Controls.Add(this.BTN_Fermer);
         this.Controls.Add(this.CB_IDSpectacle);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.Name = "ConsultationPlaces";
         this.Text = "ConsultationPlaces";
         this.Load += new System.EventHandler(this.ConsultationPlaces_Load);
         ((System.ComponentModel.ISupportInitialize)(this.DGV_Place)).EndInit();
         this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
        private System.Windows.Forms.ComboBox CB_Salle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView DGV_Place;
        private System.Windows.Forms.DataGridViewTextBoxColumn DateHeure;
        private System.Windows.Forms.DataGridViewTextBoxColumn Section;
        private System.Windows.Forms.DataGridViewTextBoxColumn NbrePlace;
        private System.Windows.Forms.ComboBox CB_IDSpectacle;
    }
}