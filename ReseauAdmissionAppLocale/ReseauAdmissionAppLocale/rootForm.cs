using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Oracle.DataAccess.Client;

namespace ReseauAdmissionAppLocale
{
   public partial class rootForm : Form
   {
      // variable contenant la connection a la bd 
      OracleConnection oraconnPrincipale = new OracleConnection();
      // boolean pour stocker si le form est connecté ou non
      public bool connection = false;

      public rootForm()
      {
         InitializeComponent();
      }

      private void rootForm_Load(object sender, EventArgs e)
      {
         //if (!connection)
         //{
         //   string Dsource = "(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)" +
         //                     "(HOST=205.237.244.251)(PORT=1521)))" +
         //                     "(CONNECT_DATA=(SERVICE_NAME=ORCL.clg.qc.ca)))";
         //   string user = "boucherm";
         //   string passwd = "ORACLE2";
         //   string chaineconnection = "Data Source = " + Dsource + ";User Id =" + user + "; Password =" + passwd;

         //   try
         //   {
         //      oraconnPrincipale.ConnectionString = chaineconnection;
         //      oraconnPrincipale.Open();
         //      connection = true;
         //   }
         //   catch (OracleException ex)
         //   {
         //      SwitchException(ex);
         //   }
         //}
      }

      private void panel1_MouseLeave(object sender, EventArgs e)
      {
          panel2.BackColor = Color.FromArgb(97, 221, 155);
      } 

      private void panel1_MouseDown(object sender, MouseEventArgs e)
      {
         panel2.BackColor = Color.FromArgb(46, 154, 96);
      }

      private void panel1_MouseEnter(object sender, EventArgs e)
      {
         panel2.BackColor = Color.FromArgb(136, 243, 186);
      }

      private void panel2_MouseLeave(object sender, EventArgs e)
      {
         panel3.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void panel2_MouseDown(object sender, MouseEventArgs e)
      {
         panel3.BackColor = Color.FromArgb(46, 154, 96);
      }

      private void panel2_MouseEnter(object sender, EventArgs e)
      {
         panel3.BackColor = Color.FromArgb(136, 243, 186);
      }

      private void panel3_MouseLeave(object sender, EventArgs e)
      {
         panel4.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void panel3_MouseDown(object sender, MouseEventArgs e)
      {
         panel4.BackColor = Color.FromArgb(46, 154, 96);
      } 

      private void panel3_MouseEnter(object sender, EventArgs e)
      {
         panel4.BackColor = Color.FromArgb(136, 243, 186);
      }

      private void panel4_MouseLeave(object sender, EventArgs e)
      {
         panel5.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void panel4_MouseDown(object sender, MouseEventArgs e)
      {
         panel5.BackColor = Color.FromArgb(46, 154, 96);
      }

      private void panel4_MouseEnter(object sender, EventArgs e)
      {
         panel5.BackColor = Color.FromArgb(136, 243, 186);
      }

      private void panel5_MouseLeave(object sender, EventArgs e)
      {
         panel6.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void panel5_MouseDown(object sender, MouseEventArgs e)
      {
         panel6.BackColor = Color.FromArgb(46, 154, 96);
      }

      private void panel5_MouseEnter(object sender, EventArgs e)
      {
         panel6.BackColor = Color.FromArgb(136, 243, 186);
      }

      private void panel4_MouseUp(object sender, MouseEventArgs e)
      {
         panel5.BackColor = Color.FromArgb(136, 243, 186);
      }
      private void panel1_MouseUp(object sender, MouseEventArgs e)
      {
         panel2.BackColor = Color.FromArgb(136, 243, 186);
      }
      private void panel2_MouseUp(object sender, MouseEventArgs e)
      {
         panel3.BackColor = Color.FromArgb(136, 243, 186);
      }
      private void panel3_MouseUp(object sender, MouseEventArgs e)
      {
         panel4.BackColor = Color.FromArgb(136, 243, 186);
      }
      private void panel5_MouseUp(object sender, MouseEventArgs e)
      {
         panel6.BackColor = Color.FromArgb(136, 243, 186);
      }

      private void SwitchException(OracleException ex)
      {
         string DescriptionErreur;
         // Va chercher l'erreur lancé et set la description dans un string 
         switch (ex.Number)
         {
            case 00001:
               DescriptionErreur = "Erreur de valeur unique.";
               break;
            case 00904:
               DescriptionErreur = "Nom de colonne invalide ou manquante.";
               break;
            case 00933:
               DescriptionErreur = "Commande SQL invalide.";
               break;
            case 00936:
               DescriptionErreur = "La commande sql exécuté est incorrecte.";
               break;
            case 00947:
               DescriptionErreur = "Il manque des informations dans la commande sql exécuté.";
               break;
            case 01008:
               DescriptionErreur = "Une tentative de liaison de variable a échoué";
               break;
            case 01017:
               DescriptionErreur = "Mot de passe ou nom d'utilisateur invalide. \nConnection non établi.";
               break;
            case 01036:
               DescriptionErreur = "Nom de variable invalide ou manquante";
               break;
            case 01400:
               DescriptionErreur = "Vous ne pouvez pas ajouter une colonne avec une valeur null.";
               break;
            case 01407:
               DescriptionErreur = "Vous ne pouvez pas mettre a jour une colonne avec une valeur null.";
               break;
            case 01410:
               DescriptionErreur = "Vous ne pouvez pas mettre de valeur null.";
               break;
            case 01438:
               DescriptionErreur = "Valeur dépassant la précision maximale dans la BD";
               break;
            case 01747:
               DescriptionErreur = "Tentative d'utilisation d'un mot reservé dans Oracle";
               break;
            case 01830:
               DescriptionErreur = "Le format de date est invalide";
               break;
            case 01843:
               DescriptionErreur = "La date n'est pas valide";
               break;
            case 01861:
               DescriptionErreur = "Le format de date est invalide";
               break;
            case 02290:
               DescriptionErreur = "Tentative d'execution d'une commande qui viole une constrainte Check";
               break;
            case 02292:
               DescriptionErreur = "Tentative de suppression d'une clé lié à une clé étrangère.";
               break;
            case 03224:
               DescriptionErreur = "Pas de connection à Mercure";
               break;
            case 12170:
               DescriptionErreur = "La base de données est indisponible, réessayer plus tard.";
               break;
            case 12504:
               DescriptionErreur = "Connexion impossible. \nLe nom d'instance Oracle est invalide.";
               break;
            case 12533:
               DescriptionErreur = "Connexion impossible. \nLe parametre de connexion d'adresse est invalide.";
               break;
            case 12541:
               DescriptionErreur = "Connexion impossible. \nLa destination est invalide ou pas rejoignable.";
               break;
            case 12543:
               DescriptionErreur = "Connexion impossible. \nVérifiez votre connection internet.";
               break;
            default:
               DescriptionErreur = ex.Message;
               break;
         }

         MessageBox.Show(DescriptionErreur, "Erreur #" + ex.Number.ToString(), MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
      }

      private void rootForm_FormClosing(object sender, FormClosingEventArgs e)
      {
          //oraconnPrincipale.Close();
      }

      private void Spectacle_Click(object sender, EventArgs e)
      {
          GestionSpectacle form = new GestionSpectacle(oraconnPrincipale);

          form.ShowDialog();
          panel2.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void Facture_Click(object sender, EventArgs e)
      {
          ConsultationClient form = new ConsultationClient(oraconnPrincipale);

          form.ShowDialog();
          panel3.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void Seating_Click(object sender, EventArgs e)
      {
          ConsultationPlaces form = new ConsultationPlaces(oraconnPrincipale);

          form.ShowDialog();
          panel4.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void ClassementVentes_Click(object sender, EventArgs e)
      {
          TopVentes form = new TopVentes(oraconnPrincipale);

          form.ShowDialog();
          panel5.BackColor = Color.FromArgb(97, 221, 155);
      }

      private void ClassementAcheteurs_Click(object sender, EventArgs e)
      {
          TopAcheteur form = new TopAcheteur(oraconnPrincipale);

          form.ShowDialog();
          panel6.BackColor = Color.FromArgb(97, 221, 155);
      }


   
   }
}
