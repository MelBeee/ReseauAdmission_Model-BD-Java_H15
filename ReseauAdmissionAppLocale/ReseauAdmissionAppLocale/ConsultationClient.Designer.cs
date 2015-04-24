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
         this.textBox1 = new System.Windows.Forms.TextBox();
         this.dataGridView1 = new System.Windows.Forms.DataGridView();
         this.NumFacture = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.Imprimé = new System.Windows.Forms.DataGridViewTextBoxColumn();
         this.NbreBillet = new System.Windows.Forms.DataGridViewTextBoxColumn();
         ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
         this.SuspendLayout();
         // 
         // BTN_Fermer
         // 
         this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Fermer.Location = new System.Drawing.Point(90, 252);
         this.BTN_Fermer.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.BTN_Fermer.Name = "BTN_Fermer";
         this.BTN_Fermer.Size = new System.Drawing.Size(72, 27);
         this.BTN_Fermer.TabIndex = 2;
         this.BTN_Fermer.Text = "Fermer";
         this.BTN_Fermer.UseVisualStyleBackColor = true;
         this.BTN_Fermer.Click += new System.EventHandler(this.BTN_Fermer_Click);
         // 
         // label2
         // 
         this.label2.AutoSize = true;
         this.label2.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label2.Location = new System.Drawing.Point(66, 7);
         this.label2.Name = "label2";
         this.label2.Size = new System.Drawing.Size(128, 17);
         this.label2.TabIndex = 7;
         this.label2.Text = "Numero Adherent";
         // 
         // textBox1
         // 
         this.textBox1.Location = new System.Drawing.Point(68, 28);
         this.textBox1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.textBox1.Name = "textBox1";
         this.textBox1.Size = new System.Drawing.Size(118, 20);
         this.textBox1.TabIndex = 8;
         // 
         // dataGridView1
         // 
         this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
         this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.NumFacture,
            this.Imprimé,
            this.NbreBillet});
         this.dataGridView1.Location = new System.Drawing.Point(9, 53);
         this.dataGridView1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.dataGridView1.Name = "dataGridView1";
         this.dataGridView1.RowHeadersVisible = false;
         this.dataGridView1.RowTemplate.Height = 24;
         this.dataGridView1.Size = new System.Drawing.Size(235, 194);
         this.dataGridView1.TabIndex = 9;
         // 
         // NumFacture
         // 
         this.NumFacture.HeaderText = "Facture";
         this.NumFacture.Name = "NumFacture";
         this.NumFacture.ReadOnly = true;
         this.NumFacture.Width = 80;
         // 
         // Imprimé
         // 
         this.Imprimé.HeaderText = "Imprimé";
         this.Imprimé.Name = "Imprimé";
         this.Imprimé.ReadOnly = true;
         this.Imprimé.Width = 80;
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
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(252, 284);
         this.Controls.Add(this.dataGridView1);
         this.Controls.Add(this.textBox1);
         this.Controls.Add(this.label2);
         this.Controls.Add(this.BTN_Fermer);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
         this.Name = "ConsultationClient";
         this.Text = "ConsultationClient";
         ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
         this.ResumeLayout(false);
         this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn NumFacture;
        private System.Windows.Forms.DataGridViewTextBoxColumn Imprimé;
        private System.Windows.Forms.DataGridViewTextBoxColumn NbreBillet;
    }
}