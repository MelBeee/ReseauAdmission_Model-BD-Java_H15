﻿namespace ReseauAdmissionAppLocale
{
    partial class GestionSpectacle
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
         this.label1 = new System.Windows.Forms.Label();
         this.label2 = new System.Windows.Forms.Label();
         this.label3 = new System.Windows.Forms.Label();
         this.TB_Nom = new System.Windows.Forms.TextBox();
         this.TB_Description = new System.Windows.Forms.TextBox();
         this.BTN_Parcourir = new System.Windows.Forms.Button();
         this.PB_Affiche = new System.Windows.Forms.PictureBox();
         this.LB_NomFichier = new System.Windows.Forms.Label();
         this.BTN_Ajouter = new System.Windows.Forms.Button();
         this.CB_Categorie = new System.Windows.Forms.ComboBox();
         this.label4 = new System.Windows.Forms.Label();
         this.OFD_Affiche = new System.Windows.Forms.OpenFileDialog();
         this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
         ((System.ComponentModel.ISupportInitialize)(this.PB_Affiche)).BeginInit();
         this.SuspendLayout();
         // 
         // BTN_Fermer
         // 
         this.BTN_Fermer.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Fermer.Location = new System.Drawing.Point(178, 303);
         this.BTN_Fermer.Margin = new System.Windows.Forms.Padding(2);
         this.BTN_Fermer.Name = "BTN_Fermer";
         this.BTN_Fermer.Size = new System.Drawing.Size(80, 27);
         this.BTN_Fermer.TabIndex = 2;
         this.BTN_Fermer.Text = "Annuler";
         this.BTN_Fermer.UseVisualStyleBackColor = true;
         this.BTN_Fermer.Click += new System.EventHandler(this.BTN_Fermer_Click);
         // 
         // label1
         // 
         this.label1.AutoSize = true;
         this.label1.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label1.Location = new System.Drawing.Point(43, 21);
         this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label1.Name = "label1";
         this.label1.Size = new System.Drawing.Size(55, 17);
         this.label1.TabIndex = 3;
         this.label1.Text = "Nom : ";
         // 
         // label2
         // 
         this.label2.AutoSize = true;
         this.label2.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label2.Location = new System.Drawing.Point(1, 65);
         this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label2.Name = "label2";
         this.label2.Size = new System.Drawing.Size(97, 17);
         this.label2.TabIndex = 4;
         this.label2.Text = "Description : ";
         // 
         // label3
         // 
         this.label3.AutoSize = true;
         this.label3.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label3.Location = new System.Drawing.Point(28, 214);
         this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label3.Name = "label3";
         this.label3.Size = new System.Drawing.Size(70, 17);
         this.label3.TabIndex = 5;
         this.label3.Text = "Affiche : ";
         // 
         // TB_Nom
         // 
         this.TB_Nom.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.TB_Nom.Location = new System.Drawing.Point(100, 17);
         this.TB_Nom.Margin = new System.Windows.Forms.Padding(2);
         this.TB_Nom.MaxLength = 100;
         this.TB_Nom.Name = "TB_Nom";
         this.TB_Nom.Size = new System.Drawing.Size(242, 26);
         this.TB_Nom.TabIndex = 6;
         this.TB_Nom.TextChanged += new System.EventHandler(this.TB_Nom_TextChanged);
         // 
         // TB_Description
         // 
         this.TB_Description.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.TB_Description.Location = new System.Drawing.Point(100, 47);
         this.TB_Description.Margin = new System.Windows.Forms.Padding(2);
         this.TB_Description.MaxLength = 300;
         this.TB_Description.Multiline = true;
         this.TB_Description.Name = "TB_Description";
         this.TB_Description.Size = new System.Drawing.Size(242, 84);
         this.TB_Description.TabIndex = 7;
         this.TB_Description.TextChanged += new System.EventHandler(this.TB_Description_TextChanged);
         // 
         // BTN_Parcourir
         // 
         this.BTN_Parcourir.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.BTN_Parcourir.Location = new System.Drawing.Point(98, 165);
         this.BTN_Parcourir.Margin = new System.Windows.Forms.Padding(2);
         this.BTN_Parcourir.Name = "BTN_Parcourir";
         this.BTN_Parcourir.Size = new System.Drawing.Size(75, 26);
         this.BTN_Parcourir.TabIndex = 8;
         this.BTN_Parcourir.Text = "Parcourir";
         this.BTN_Parcourir.UseVisualStyleBackColor = true;
         this.BTN_Parcourir.Click += new System.EventHandler(this.BTN_Parcourir_Click);
         // 
         // PB_Affiche
         // 
         this.PB_Affiche.Location = new System.Drawing.Point(100, 197);
         this.PB_Affiche.Margin = new System.Windows.Forms.Padding(2);
         this.PB_Affiche.Name = "PB_Affiche";
         this.PB_Affiche.Size = new System.Drawing.Size(241, 94);
         this.PB_Affiche.TabIndex = 9;
         this.PB_Affiche.TabStop = false;
         // 
         // LB_NomFichier
         // 
         this.LB_NomFichier.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.LB_NomFichier.ForeColor = System.Drawing.Color.White;
         this.LB_NomFichier.Location = new System.Drawing.Point(175, 171);
         this.LB_NomFichier.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.LB_NomFichier.Name = "LB_NomFichier";
         this.LB_NomFichier.Size = new System.Drawing.Size(164, 15);
         this.LB_NomFichier.TabIndex = 10;
         this.LB_NomFichier.Text = "Nom du fichier";
         // 
         // BTN_Ajouter
         // 
         this.BTN_Ajouter.Font = new System.Drawing.Font("Forte", 13.2F);
         this.BTN_Ajouter.Location = new System.Drawing.Point(93, 303);
         this.BTN_Ajouter.Margin = new System.Windows.Forms.Padding(2);
         this.BTN_Ajouter.Name = "BTN_Ajouter";
         this.BTN_Ajouter.Size = new System.Drawing.Size(80, 27);
         this.BTN_Ajouter.TabIndex = 11;
         this.BTN_Ajouter.Text = "Ajouter";
         this.BTN_Ajouter.UseVisualStyleBackColor = true;
         this.BTN_Ajouter.Click += new System.EventHandler(this.BTN_Ajouter_Click);
         // 
         // CB_Categorie
         // 
         this.CB_Categorie.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
         this.CB_Categorie.Font = new System.Drawing.Font("Forte", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.CB_Categorie.FormattingEnabled = true;
         this.CB_Categorie.Location = new System.Drawing.Point(100, 136);
         this.CB_Categorie.Margin = new System.Windows.Forms.Padding(2);
         this.CB_Categorie.Name = "CB_Categorie";
         this.CB_Categorie.Size = new System.Drawing.Size(242, 23);
         this.CB_Categorie.TabIndex = 12;
         this.CB_Categorie.SelectedIndexChanged += new System.EventHandler(this.CB_Categorie_SelectedIndexChanged);
         // 
         // label4
         // 
         this.label4.AutoSize = true;
         this.label4.Font = new System.Drawing.Font("Forte", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
         this.label4.Location = new System.Drawing.Point(11, 138);
         this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
         this.label4.Name = "label4";
         this.label4.Size = new System.Drawing.Size(87, 17);
         this.label4.TabIndex = 13;
         this.label4.Text = "Catégorie : ";
         // 
         // OFD_Affiche
         // 
         this.OFD_Affiche.FileName = "openFileDialog1";
         // 
         // GestionSpectacle
         // 
         this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
         this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
         this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(67)))), ((int)(((byte)(189)))), ((int)(((byte)(124)))));
         this.ClientSize = new System.Drawing.Size(350, 336);
         this.Controls.Add(this.label4);
         this.Controls.Add(this.CB_Categorie);
         this.Controls.Add(this.BTN_Ajouter);
         this.Controls.Add(this.LB_NomFichier);
         this.Controls.Add(this.PB_Affiche);
         this.Controls.Add(this.BTN_Parcourir);
         this.Controls.Add(this.TB_Description);
         this.Controls.Add(this.TB_Nom);
         this.Controls.Add(this.label3);
         this.Controls.Add(this.label2);
         this.Controls.Add(this.label1);
         this.Controls.Add(this.BTN_Fermer);
         this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
         this.Margin = new System.Windows.Forms.Padding(2);
         this.Name = "GestionSpectacle";
         this.Text = "Nouveau spectacle";
         this.Load += new System.EventHandler(this.GestionSpectacle_Load);
         ((System.ComponentModel.ISupportInitialize)(this.PB_Affiche)).EndInit();
         this.ResumeLayout(false);
         this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button BTN_Fermer;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox TB_Nom;
        private System.Windows.Forms.TextBox TB_Description;
        private System.Windows.Forms.Button BTN_Parcourir;
        private System.Windows.Forms.PictureBox PB_Affiche;
        private System.Windows.Forms.Label LB_NomFichier;
        private System.Windows.Forms.Button BTN_Ajouter;
        private System.Windows.Forms.ComboBox CB_Categorie;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.OpenFileDialog OFD_Affiche;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
    }
}