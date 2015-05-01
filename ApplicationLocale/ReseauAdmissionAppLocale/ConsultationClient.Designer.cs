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
            this.label2 = new System.Windows.Forms.Label();
            this.TB_NomID = new System.Windows.Forms.TextBox();
            this.DGV_facture = new System.Windows.Forms.DataGridView();
            this.BTN_Afficher = new System.Windows.Forms.Button();
            this.NumFacture = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Imprime = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NbreBillet = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.DGV_facture)).BeginInit();
            this.SuspendLayout();
            // 
            // BTN_Fermer
            // 
            this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
            this.BTN_Fermer.Location = new System.Drawing.Point(120, 310);
            this.BTN_Fermer.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.BTN_Fermer.Name = "BTN_Fermer";
            this.BTN_Fermer.Size = new System.Drawing.Size(96, 33);
            this.BTN_Fermer.TabIndex = 2;
            this.BTN_Fermer.Text = "Fermer";
            this.BTN_Fermer.UseVisualStyleBackColor = true;
            this.BTN_Fermer.Click += new System.EventHandler(this.BTN_Fermer_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(13, 9);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(190, 22);
            this.label2.TabIndex = 7;
            this.label2.Text = "Nom ou # d\'adherent";
            // 
            // TB_NomID
            // 
            this.TB_NomID.Location = new System.Drawing.Point(12, 36);
            this.TB_NomID.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.TB_NomID.Name = "TB_NomID";
            this.TB_NomID.Size = new System.Drawing.Size(191, 22);
            this.TB_NomID.TabIndex = 8;
            // 
            // DGV_facture
            // 
            this.DGV_facture.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGV_facture.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.NumFacture,
            this.Imprime,
            this.NbreBillet});
            this.DGV_facture.Location = new System.Drawing.Point(12, 65);
            this.DGV_facture.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.DGV_facture.Name = "DGV_facture";
            this.DGV_facture.RowHeadersVisible = false;
            this.DGV_facture.RowTemplate.Height = 24;
            this.DGV_facture.Size = new System.Drawing.Size(313, 239);
            this.DGV_facture.TabIndex = 9;
            // 
            // BTN_Afficher
            // 
            this.BTN_Afficher.Font = new System.Drawing.Font("Forte", 13.2F);
            this.BTN_Afficher.Location = new System.Drawing.Point(210, 8);
            this.BTN_Afficher.Name = "BTN_Afficher";
            this.BTN_Afficher.Size = new System.Drawing.Size(115, 50);
            this.BTN_Afficher.TabIndex = 10;
            this.BTN_Afficher.Text = "Afficher";
            this.BTN_Afficher.UseVisualStyleBackColor = true;
            this.BTN_Afficher.Click += new System.EventHandler(this.BTN_Afficher_Click);
            // 
            // NumFacture
            // 
            this.NumFacture.HeaderText = "Facture";
            this.NumFacture.Name = "NumFacture";
            this.NumFacture.ReadOnly = true;
            this.NumFacture.Width = 80;
            // 
            // Imprime
            // 
            this.Imprime.HeaderText = "Imprimé";
            this.Imprime.Name = "Imprime";
            this.Imprime.ReadOnly = true;
            this.Imprime.Width = 80;
            // 
            // NbreBillet
            // 
            this.NbreBillet.HeaderText = "Nombre Billets";
            this.NbreBillet.Name = "NbreBillet";
            this.NbreBillet.ReadOnly = true;
            this.NbreBillet.Width = 70;
            // 
            // ConsultationClient
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
            this.ClientSize = new System.Drawing.Size(336, 350);
            this.Controls.Add(this.BTN_Afficher);
            this.Controls.Add(this.DGV_facture);
            this.Controls.Add(this.TB_NomID);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.BTN_Fermer);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "ConsultationClient";
            this.Text = "ConsultationClient";
            this.Load += new System.EventHandler(this.ConsultationClient_Load);
            ((System.ComponentModel.ISupportInitialize)(this.DGV_facture)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox TB_NomID;
        private System.Windows.Forms.DataGridView DGV_facture;
        private System.Windows.Forms.Button BTN_Afficher;
        private System.Windows.Forms.DataGridViewTextBoxColumn NumFacture;
        private System.Windows.Forms.DataGridViewTextBoxColumn Imprime;
        private System.Windows.Forms.DataGridViewTextBoxColumn NbreBillet;
    }
}