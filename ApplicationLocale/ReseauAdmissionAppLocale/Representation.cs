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
   public partial class Representation : Form
   {
      // variable contenant la connection a la bd 
      OracleConnection oraconnPrincipale = new OracleConnection();
      private const int CP_NOCLOSE_BUTTON = 0x200;
      const char BACKSPACE = '\b';
      string NomSpectacle = "";
      string NomSalle = "";
      string DateSpectacle = "";
      string Section = "";
      string Prix = "";


      public Representation(OracleConnection oraconn)
      {
         InitializeComponent();
         oraconnPrincipale = oraconn;
      }

      private void Representation_Load(object sender, EventArgs e)
      {
         LoadComboBoxSalle();
         LoadComboBoxSpectacle();
         BTN_AjouterHeureSalle.Enabled = false;
         BTN_AjouterSectionPrix.Enabled = false;
         CB_Section.Enabled = false;
         TB_Prix.Enabled = false;
      }

      private void LoadComboBoxSpectacle()
      {
         try
         {
            OracleCommand oraFacture = new OracleCommand("AppLocale", oraconnPrincipale);
            oraFacture.CommandText = "AppLocale.GETSPECTACLE";
            oraFacture.CommandType = CommandType.StoredProcedure;

            OracleParameter Curseur = new OracleParameter("Resultat", OracleDbType.RefCursor);
            Curseur.Direction = ParameterDirection.Output;

            oraFacture.Parameters.Add(Curseur);

            OracleDataReader OraRead = oraFacture.ExecuteReader();

            while (OraRead.Read())
            {
               CB_Spectacle.Items.Add(OraRead.GetString(1));
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
      }

      private void LoadComboBoxSalle()
      {
         try
         {
            OracleCommand cmdGetSalle = new OracleCommand("AppLocale", oraconnPrincipale);
            cmdGetSalle.CommandType = CommandType.StoredProcedure;
            cmdGetSalle.CommandText = "AppLocale.getsalle";

            OracleParameter unCursor = new OracleParameter("Resultat", OracleDbType.RefCursor);
            unCursor.Direction = ParameterDirection.Output;

            cmdGetSalle.Parameters.Add(unCursor);

            OracleDataReader OraRead = cmdGetSalle.ExecuteReader();

            while (OraRead.Read())
            {
               CB_Salle.Items.Add(OraRead.GetString(0));
            }

            cmdGetSalle.Dispose();
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

      protected override CreateParams CreateParams
      {
         get
         {
            CreateParams mdiCp = base.CreateParams;
            mdiCp.ClassStyle = mdiCp.ClassStyle | CP_NOCLOSE_BUTTON;
            return mdiCp;
         }
      }

      private void button2_Click(object sender, EventArgs e)
      {
         this.Close();
      }

      private void BTN_AjouterHeureSalle_Click(object sender, EventArgs e)
      {
         CB_Section.Enabled = true;
         LoadComboBoxSection();
         NomSpectacle = CB_Spectacle.Text;
         NomSalle = CB_Salle.Text;
         DateSpectacle = DTP_DateSpectacle.Text;
         CB_Spectacle.Enabled = false;
         CB_Salle.Enabled = false;
         DTP_DateSpectacle.Enabled = false;
         BTN_AjouterHeureSalle.Enabled = false;
         TB_Prix.Enabled = true;
      }

      private void UpdateSalleControl()
      {
         if (CB_Salle.Text == "" || CB_Spectacle.Text == "" || DTP_DateSpectacle.Text == "")
         {
            BTN_AjouterHeureSalle.Enabled = false;
         }
         else
         {
            BTN_AjouterHeureSalle.Enabled = true;
         }
      }

      private void UpdateSectionControl()
      {
         if (CB_Section.Text == "" || TB_Prix.Text == "")
         {
            BTN_AjouterSectionPrix.Enabled = false;
         }
         else
         {
            BTN_AjouterSectionPrix.Enabled = true;
         }
      }

      private void LoadComboBoxSection()
      {
         CB_Section.Items.Clear();
         try
         {
            OracleCommand cmdGetGestion = new OracleCommand("AppLocale", oraconnPrincipale);
            cmdGetGestion.CommandType = CommandType.StoredProcedure;
            cmdGetGestion.CommandText = "AppLocale.getsection";

            OracleParameter unCursor = new OracleParameter("Resultat", OracleDbType.RefCursor);
            unCursor.Direction = ParameterDirection.Output;

            OracleParameter oraNomSalle = new OracleParameter("PNom", OracleDbType.Varchar2);
            oraNomSalle.Direction = ParameterDirection.Input;
            oraNomSalle.Value = CB_Salle.Text;

            cmdGetGestion.Parameters.Add(unCursor);
            cmdGetGestion.Parameters.Add(oraNomSalle);

            OracleDataReader OraRead = cmdGetGestion.ExecuteReader();

            while (OraRead.Read())
            {
               CB_Section.Items.Add(OraRead.GetString(0));
            }

            cmdGetGestion.Dispose();
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

      private void BTN_AjouterSectionPrix_Click(object sender, EventArgs e)
      {
         int indexcbsection = CB_Section.SelectedIndex;
         Section = CB_Section.Text;
         Prix = TB_Prix.Text;
         if (AjoutRepresentation())
         {
            BTN_Quitter.Enabled = false;
            CB_Section.Items.RemoveAt(indexcbsection);
         }
         if (CB_Section.Items.Count == 0)
         {
            CB_Section.Enabled = false;
            TB_Prix.Enabled = false;
            BTN_Quitter.Enabled = true;
            LB_Attention.Text = "Vous pouvez maintenant quitter";
            LB_Attention.ForeColor = Color.DarkGreen;
         }
      }

      // PNomSPECTACLE IN SPECTACLE.Nom%TYPE, PSECTION IN BILLET.IDSECTION%TYPE, PDATE IN BILLET.LADATEHEURE%TYPE, PPRIX IN BILLET.PRIX%TYPE
      private bool AjoutRepresentation()
      {
         bool reussi = true;
         try
         {
            OracleCommand cmdInsertSpectacle = new OracleCommand("AppLocale", oraconnPrincipale);
            cmdInsertSpectacle.CommandType = CommandType.StoredProcedure;
            cmdInsertSpectacle.CommandText = "AppLocale.InsertionSpectacle";

            OracleParameter pNom = new OracleParameter("PNomSPECTACLE", OracleDbType.Varchar2);
            pNom.Direction = ParameterDirection.Input;
            OracleParameter pSection = new OracleParameter("PSECTION", OracleDbType.Varchar2);
            pNom.Direction = ParameterDirection.Input;
            OracleParameter pDate = new OracleParameter("PDATE", OracleDbType.Date);
            pNom.Direction = ParameterDirection.Input;
            OracleParameter pPrix = new OracleParameter("PPRIX", OracleDbType.Int32);
            pNom.Direction = ParameterDirection.Input;
            OracleParameter pSalle = new OracleParameter("PSalle", OracleDbType.Varchar2);
            pSalle.Direction = ParameterDirection.Input;

            pNom.Value = NomSpectacle;
            pSection.Value = Section;
            pDate.Value = DateSpectacle;
            pPrix.Value = Prix;
            pSalle.Value = NomSalle;

            cmdInsertSpectacle.Parameters.Add(pNom);
            cmdInsertSpectacle.Parameters.Add(pSection);
            cmdInsertSpectacle.Parameters.Add(pDate);
            cmdInsertSpectacle.Parameters.Add(pPrix);
            cmdInsertSpectacle.Parameters.Add(pSalle);

            cmdInsertSpectacle.ExecuteNonQuery();
            cmdInsertSpectacle.Dispose();
         }
         catch (OracleException oex)
         {
            SwitchException(oex);
            reussi = false;
         }
         catch (Exception ex)
         {
            MessageBox.Show(ex.Message);
            reussi = false;
         }
         finally
         {
            if (reussi)
            {
               MessageBox.Show("Insertion reussite");
               this.Close();
            }
            else
            {
               MessageBox.Show("Insertion non reussite");
            }
         }

         return reussi;
      }



      private void textBox2_TextChanged(object sender, EventArgs e)
      {
         UpdateSalleControl();
      }

      private void DTP_DateSpectacle_ValueChanged(object sender, EventArgs e)
      {
         UpdateSalleControl();
      }

      private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
      {
         UpdateSalleControl();
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

      private void CB_Section_SelectedIndexChanged(object sender, EventArgs e)
      {
         UpdateSectionControl();
      }

      private void TB_Prix_TextChanged(object sender, EventArgs e)
      {
         UpdateSectionControl();
      }

      private void TB_Prix_KeyPress(object sender, KeyPressEventArgs e)
      {
         if (e.KeyChar != BACKSPACE)
            e.Handled = !EstChiffre(e.KeyChar);
      }

      bool EstChiffre(char c)
      {
         string chiffres = "0123456789.";
         return (chiffres.IndexOf(c.ToString()) != -1);
      }
   }
}
