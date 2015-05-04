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
            this.NumFacture = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Imprime = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NbreBillet = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.BTN_Afficher = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.LB_Adresse = new System.Windows.Forms.Label();
            this.LB_Telephone = new System.Windows.Forms.Label();
            this.LB_Username = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.DGV_facture)).BeginInit();
            this.SuspendLayout();
            // 
            // BTN_Fermer
            // 
            this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
            this.BTN_Fermer.Location = new System.Drawing.Point(120, 390);
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
            this.label2.Location = new System.Drawing.Point(28, 8);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(165, 22);
            this.label2.TabIndex = 7;
            this.label2.Text = "numéro d\'adherent";
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
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(32, 337);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(89, 22);
            this.label1.TabIndex = 11;
            this.label1.Text = "Adresse :";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(13, 361);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(108, 22);
            this.label3.TabIndex = 12;
            this.label3.Text = "Telephone :";
            // 
            // LB_Adresse
            // 
            this.LB_Adresse.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LB_Adresse.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(1)))), ((int)(((byte)(100)))), ((int)(((byte)(100)))));
            this.LB_Adresse.Location = new System.Drawing.Point(120, 337);
            this.LB_Adresse.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LB_Adresse.Name = "LB_Adresse";
            this.LB_Adresse.Size = new System.Drawing.Size(205, 22);
            this.LB_Adresse.TabIndex = 13;
            // 
            // LB_Telephone
            // 
            this.LB_Telephone.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LB_Telephone.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(1)))), ((int)(((byte)(100)))), ((int)(((byte)(100)))));
            this.LB_Telephone.Location = new System.Drawing.Point(120, 361);
            this.LB_Telephone.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LB_Telephone.Name = "LB_Telephone";
            this.LB_Telephone.Size = new System.Drawing.Size(205, 22);
            this.LB_Telephone.TabIndex = 14;
            // 
            // LB_Username
            // 
            this.LB_Username.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LB_Username.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(1)))), ((int)(((byte)(100)))), ((int)(((byte)(100)))));
            this.LB_Username.Location = new System.Drawing.Point(120, 314);
            this.LB_Username.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.LB_Username.Name = "LB_Username";
            this.LB_Username.Size = new System.Drawing.Size(205, 22);
            this.LB_Username.TabIndex = 16;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(18, 314);
            this.label5.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(103, 22);
            this.label5.TabIndex = 15;
            this.label5.Text = "Username :";
            // 
            // ConsultationClient
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
            this.ClientSize = new System.Drawing.Size(336, 427);
            this.Controls.Add(this.LB_Username);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.LB_Telephone);
            this.Controls.Add(this.LB_Adresse);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label1);
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
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label LB_Adresse;
        private System.Windows.Forms.Label LB_Telephone;
        private System.Windows.Forms.Label LB_Username;
        private System.Windows.Forms.Label label5;
    }
}