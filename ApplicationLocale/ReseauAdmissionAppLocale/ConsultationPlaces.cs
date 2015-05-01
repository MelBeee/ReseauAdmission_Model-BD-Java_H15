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
    public partial class ConsultationPlaces : Form
    {
        // variable contenant la connection a la bd 
        OracleConnection oraconnPrincipale = new OracleConnection();

        public ConsultationPlaces(OracleConnection connection)
        {
            InitializeComponent();
            oraconnPrincipale = connection;
        }

        private void BTN_Fermer_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void ConsultationPlaces_Load(object sender, EventArgs e)
        {
            SetWidthColumn();
            RemplirComboBox();
        }

        private void RemplirComboBox()
        {

        }

        private void SetWidthColumn()
        {
            int widthdgv = DGV_Place.Width - 3;

            DateHeure.Width = 40 * widthdgv / 100;
            Section.Width = 40 * widthdgv / 100;
            NbrePlace.Width = 20 * widthdgv / 100;
        }

        private void CB_Salle_SelectedIndexChanged(object sender, EventArgs e)
        {
            bool resultat = false;
            try
            {
                OracleCommand oraFacture = new OracleCommand("AppLocale", oraconnPrincipale);
                oraFacture.CommandText = "AppLocale.GetLesFacturesDesClients";
                oraFacture.CommandType = CommandType.StoredProcedure;

                OracleParameter IdClient = new OracleParameter("PIDClient", OracleDbType.Int32);
                IdClient.Direction = ParameterDirection.Input;
                IdClient.Value = Convert.ToInt32(CB_Salle.SelectedText.ToString());

                OracleParameter Curseur = new OracleParameter("Resultat", OracleDbType.RefCursor);
                Curseur.Direction = ParameterDirection.Output;

                oraFacture.Parameters.Add(IdClient);
                oraFacture.Parameters.Add(Curseur);

                OracleDataReader OraRead = oraFacture.ExecuteReader();

                while (OraRead.Read())
                {
                    DataGridViewRow row = (DataGridViewRow)DGV_Place.Rows[0].Clone();
                    row.Cells[0].Value = OraRead.GetDateTime(0).ToLongDateString();
                    row.Cells[1].Value = OraRead.GetString(1).ToString();
                    row.Cells[2].Value = AnalyseNombre(Convert.ToInt32(OraRead.GetInt32(4)), Convert.ToInt32(OraRead.GetInt32(3)));
                    DGV_Place.Rows.Add(row);
                    resultat = true;
                }

                oraFacture.Dispose();
                OraRead.Close();
            }
            catch (OracleException ioe)
            {

            }
            catch (Exception ioe)
            {

            }
            finally
            {
                if (!resultat)
                {
                    MessageBox.Show("Aucune représentation disponible");
                }
            }
        }

        private string AnalyseNombre(int nbreplacedispo, int nbreplace)
        {
            string nbreplacerestante = nbreplacedispo.ToString();

            if(nbreplacedispo == null)
            {
                nbreplacerestante = nbreplace.ToString();
            }

            return nbreplacerestante;
        }
    }
}
