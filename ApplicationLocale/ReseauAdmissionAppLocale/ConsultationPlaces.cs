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
                    CB_Salle.Items.Add(OraRead.GetString(1));
                    CB_IDSpectacle.Items.Add(OraRead.GetInt64(0));
                }

                oraFacture.Dispose();
                OraRead.Close();
            }
            catch (OracleException ioe)
            {
                MessageBox.Show("Erreur Oracle");
            }
            catch (Exception ioe)
            {
                MessageBox.Show("Erreur ");
            }
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
            DGV_Place.Rows.Clear();
            bool resultat = false;
            try
            {
                OracleCommand oraFacture = new OracleCommand("AppLocale", oraconnPrincipale);
                oraFacture.CommandText = "AppLocale.GetNbrePlaces";
                oraFacture.CommandType = CommandType.StoredProcedure;

                OracleParameter IdClient = new OracleParameter("PIDClient", OracleDbType.Int32);
                IdClient.Direction = ParameterDirection.Input;
                CB_IDSpectacle.SelectedIndex = CB_Salle.SelectedIndex;
                IdClient.Value = CB_IDSpectacle.Text;

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
                    if(!OraRead.IsDBNull(OraRead.GetInt32(4)))
                    {
                        row.Cells[2].Value = OraRead.GetInt32(3);
                    }
                    else
                    {
                        row.Cells[2].Value = OraRead.GetInt32(4);
                    }
                    DGV_Place.Rows.Add(row);
                    resultat = true;
                }

                oraFacture.Dispose();
                OraRead.Close();
            }
            catch (OracleException ioe)
            {
                MessageBox.Show("Oracle Erreur");
            }
            catch (Exception ioe)
            {
                MessageBox.Show(ioe.Message.ToString());
            }
            finally
            {
                if (!resultat)
                {
                    MessageBox.Show("Aucune représentation disponible");
                }
            }
        }
    }
}
