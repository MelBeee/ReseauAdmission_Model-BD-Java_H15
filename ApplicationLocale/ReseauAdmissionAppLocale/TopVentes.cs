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
    public partial class TopVentes : Form
    {
        // variable contenant la connection a la bd 
        OracleConnection oraconnPrincipale = new OracleConnection();

        public TopVentes(OracleConnection connection)
        {
            InitializeComponent();
            oraconnPrincipale = connection;
        }

        private void BTN_Fermer_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void TopVentes_Load(object sender, EventArgs e)
        {
            AfficherLeTop();
        }

        private void AfficherLeTop()
        {
            try
            {
                OracleCommand cmdTopVente = new OracleCommand("AppLocale", oraconnPrincipale);
                cmdTopVente.CommandType = CommandType.StoredProcedure;
                cmdTopVente.CommandText = "AppLocale.GetTopVenteBillet";

                OracleParameter unCursor = new OracleParameter("Resultat", OracleDbType.RefCursor);
                unCursor.Direction = ParameterDirection.Output;

                cmdTopVente.Parameters.Add(unCursor);

                OracleDataReader OraRead = cmdTopVente.ExecuteReader();

                // Gold
                OraRead.Read();
                LB_Gold_Nom.Text = OraRead.GetString(0);
                LB_Gold_Nombre.Text = OraRead.GetInt64(1).ToString() + " billets";
                //PB_Gold_Image.ImageLocation = OraRead.GetString(2);

                // Silver
                OraRead.Read();
                LB_Silver_Nom.Text = OraRead.GetString(0);
                LB_Silver_Nombre.Text = OraRead.GetInt64(1).ToString() + " billets";
                //PB_Silver_Image.ImageLocation = OraRead.GetString(2);

                // Bronze
                OraRead.Read();
                LB_Bronze_Nom.Text = OraRead.GetString(0);
                LB_Bronze_Nombre.Text = OraRead.GetInt64(1).ToString() + " billets";
                //PB_Bronze_Image.ImageLocation = OraRead.GetString(2);

                cmdTopVente.Dispose();
                OraRead.Close();
            }
            catch(OracleException oex)
            {
                SwitchException(oex);
            }
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
    }
}
