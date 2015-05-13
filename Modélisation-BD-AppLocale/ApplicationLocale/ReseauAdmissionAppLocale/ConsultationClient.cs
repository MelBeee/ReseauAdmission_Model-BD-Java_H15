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
   public partial class ConsultationClient : Form
   {
      // variable contenant la connection a la bd 
      OracleConnection oraconnPrincipale = new OracleConnection();
      const char BACKSPACE = '\b';


      public ConsultationClient(OracleConnection connection)
      {
         InitializeComponent();
         oraconnPrincipale = connection;
      }

      private void BTN_Fermer_Click(object sender, EventArgs e)
      {
         this.Close();
      }

      private void ConsultationClient_Load(object sender, EventArgs e)
      {
         UpdateControl(); 
         WidthColonne();
      }

      private void WidthColonne()
      {
         int widthdgv = DGV_facture.Width - 3;
         Imprime.Width = widthdgv / 3;
         NumFacture.Width = widthdgv / 3;
         NbreBillet.Width = widthdgv / 3;
      }

      private void BTN_Afficher_Click(object sender, EventArgs e)
      {
         DGV_facture.Rows.Clear();
         ChercherInfo();
      }

      private void ChercherInfo()
      {
         bool resultat = false;
         try
         {
            OracleCommand oraFacture = new OracleCommand("AppLocale", oraconnPrincipale);
            oraFacture.CommandText = "AppLocale.GetLesFacturesDesClients";
            oraFacture.CommandType = CommandType.StoredProcedure;

            OracleParameter IdClient = new OracleParameter("PIDClient", OracleDbType.Varchar2);
            IdClient.Direction = ParameterDirection.Input;
            IdClient.Value = TB_NomID.Text;

            OracleParameter Curseur = new OracleParameter("Resultat", OracleDbType.RefCursor);
            Curseur.Direction = ParameterDirection.Output;

            oraFacture.Parameters.Add(IdClient);
            oraFacture.Parameters.Add(Curseur);

            OracleDataReader OraRead = oraFacture.ExecuteReader();

            while (OraRead.Read())
            {
               DataGridViewRow row = (DataGridViewRow)DGV_facture.Rows[0].Clone();
               row.Cells[0].Value = OraRead.GetInt64(0).ToString();
               row.Cells[1].Value = AnalyseColImprime(OraRead.GetString(1).ToString());
               row.Cells[2].Value = OraRead.GetInt64(2).ToString();
               TB_NomID.Text = OraRead.GetInt64(3).ToString();
               DGV_facture.Rows.Add(row);
               resultat = true;
            }

            oraFacture.Dispose();
            OraRead.Close();
         }
         catch (OracleException oex)
         {
            SwitchException(oex);
         }
         catch (Exception ex)
         {
            MessageBox.Show(ex.Message.ToString());
         }
         finally
         {
            if (!resultat)
            {
               LB_Adresse.Text = "";
               LB_Telephone.Text = "";
               LB_Username.Text = "";
               MessageBox.Show("Aucune facture trouvée ou id utilisateur incorrecte");
            }
            else
            {
               try
               {
                  OracleCommand oraClient = new OracleCommand("AppLocal", oraconnPrincipale);
                  oraClient.CommandText = "AppLocale.GETINFOCLIENT";
                  oraClient.CommandType = CommandType.StoredProcedure;

                  OracleParameter IdClient = new OracleParameter("PIDClient", OracleDbType.Int64);
                  IdClient.Direction = ParameterDirection.Input;
                  IdClient.Value = TB_NomID.Text;

                  OracleParameter Curseur = new OracleParameter("Resultat", OracleDbType.RefCursor);
                  Curseur.Direction = ParameterDirection.Output;

                  oraClient.Parameters.Add(Curseur);
                  oraClient.Parameters.Add(IdClient);

                  OracleDataReader OraRead = oraClient.ExecuteReader();

                  while (OraRead.Read())
                  {
                     LB_Username.Text = OraRead.GetString(0);
                     LB_Telephone.Text = OraRead.GetString(1);
                     LB_Adresse.Text = OraRead.GetString(2);
                  }

                  oraClient.Dispose();
                  OraRead.Close();
               }
               catch (OracleException oex)
               {
                  SwitchException(oex);
               }
               catch (Exception ex)
               {
                  MessageBox.Show(ex.Message.ToString());
               }
            }
         }
      }

      private string AnalyseColImprime(string imp)
      {
         string returnvalue = "Oui";

         if (imp == "1")
         {
            returnvalue = "Non";
         }

         return returnvalue;
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

      private void TB_NomID_TextChanged(object sender, EventArgs e)
      {
         UpdateControl();
      }

      private void UpdateControl()
      {
         if(TB_NomID.Text == "")
         {
            BTN_Afficher.Enabled = false;
         }
         else
         {
            BTN_Afficher.Enabled = true; 
         }
      }

      private void TB_NomID_KeyPress(object sender, KeyPressEventArgs e)
      {
         if (e.KeyChar != BACKSPACE)
            e.Handled = !EstChiffre(e.KeyChar);
      }

      bool EstChiffre(char c)
      {
         String chiffres = "0123456789";
         return (chiffres.IndexOf(c.ToString()) != -1);
      }
   }
}
