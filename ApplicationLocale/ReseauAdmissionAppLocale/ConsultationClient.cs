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
            catch(OracleException ioe)
            {

            }
            catch(Exception ioe)
            {

            }
            finally
            {
                if (!resultat)
                {
                    MessageBox.Show("Utilisateur n'existe pas/Aucune facture trouvée");
                }
            }
            if(resultat)
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
                catch(OracleException oe)
                {
                    MessageBox.Show(oe.Message.ToString());
                }
                catch(Exception ex)
                {

                }
            }
        }

        private string AnalyseColImprime(string imp)
        {
            string returnvalue = "Oui";

            if(imp == "1")
            {
                returnvalue = "Non";
            }

            return returnvalue;
        }
    }
}
