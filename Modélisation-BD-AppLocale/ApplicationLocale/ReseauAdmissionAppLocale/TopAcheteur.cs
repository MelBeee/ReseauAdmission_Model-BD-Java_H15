﻿using System;
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
    public partial class TopAcheteur : Form
    {
        // variable contenant la connection a la bd 
        OracleConnection oraconnPrincipale = new OracleConnection();

        public TopAcheteur(OracleConnection connection)
        {
            InitializeComponent();
            oraconnPrincipale = connection;
        }

        private void TopAcheteur_Load(object sender, EventArgs e)
        {
            AfficherTopAcheteur();
            AfficherTopCategorie();
        }

        private void BTN_Fermer_Click_1(object sender, EventArgs e)
        {
            this.Close();
        }

        private void AfficherTopCategorie()
        {
            try
            {
                OracleCommand cmdTopVente = new OracleCommand("AppLocale", oraconnPrincipale);
                cmdTopVente.CommandType = CommandType.StoredProcedure;
                cmdTopVente.CommandText = "AppLocale.GetTopCategorie";

                OracleParameter unCursor = new OracleParameter("Resultat", OracleDbType.RefCursor);
                unCursor.Direction = ParameterDirection.Output;

                cmdTopVente.Parameters.Add(unCursor);

                OracleDataReader OraRead = cmdTopVente.ExecuteReader();

                // Gold
                if (OraRead.Read())
                {
                    LB_NomCat_Gold.Text = OraRead.GetString(0);
                    LB_NbreCat_Gold.Text = OraRead.GetInt64(1).ToString() + " billets";
                }
                else
                {
                    LB_NomCat_Gold.Text = "";
                    LB_NbreCat_Gold.Text = "";
                }
                if (OraRead.Read())
                {
                    LB_NomCat_Silver.Text = OraRead.GetString(0);
                    LB_NbreCat_Silver.Text = OraRead.GetInt64(1).ToString() + " billets";
                }
                else
                {
                    LB_NomCat_Silver.Text = "";
                    LB_NbreCat_Silver.Text = "";
                }
                if (OraRead.Read())
                {
                    LB_NomCat_Bronze.Text = OraRead.GetString(0);
                    LB_NbreCat_Bronze.Text = OraRead.GetInt64(1).ToString() + " billets";
                }
                else
                {
                    LB_NomCat_Bronze.Text = "";
                    LB_NbreCat_Bronze.Text = "";
                }

                cmdTopVente.Dispose();
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

        private void AfficherTopAcheteur()
        {
            try
            {
                OracleCommand cmdTopVente = new OracleCommand("AppLocale", oraconnPrincipale);
                cmdTopVente.CommandType = CommandType.StoredProcedure;
                cmdTopVente.CommandText = "AppLocale.GetTopClientAcheteur";

                OracleParameter unCursor = new OracleParameter("Resultat", OracleDbType.RefCursor);
                unCursor.Direction = ParameterDirection.Output;

                cmdTopVente.Parameters.Add(unCursor);

                OracleDataReader OraRead = cmdTopVente.ExecuteReader();

                // Gold
                if (OraRead.Read())
                {
                    LB_Gold_Nom.Text = OraRead.GetString(0);
                    LB_Gold_Nombre.Text = OraRead.GetInt64(1).ToString() + " billets";
                }
                else
                {
                    LB_Gold_Nom.Text = "";
                    LB_Gold_Nombre.Text = "";
                }
                if (OraRead.Read())
                {
                    LB_Silver_Nom.Text = OraRead.GetString(0);
                    LB_Silver_Nombre.Text = OraRead.GetInt64(1).ToString() + " billets";
                }
                else
                {
                    LB_Silver_Nom.Text = "";
                    LB_Silver_Nombre.Text = "";
                }
                if (OraRead.Read())
                {
                    LB_Bronze_Nom.Text = OraRead.GetString(0);
                    LB_Bronze_Nombre.Text = OraRead.GetInt64(1).ToString() + " billets";
                }
                else
                {
                    LB_Bronze_Nom.Text = "";
                    LB_Bronze_Nombre.Text = "";
                }

                cmdTopVente.Dispose();
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
