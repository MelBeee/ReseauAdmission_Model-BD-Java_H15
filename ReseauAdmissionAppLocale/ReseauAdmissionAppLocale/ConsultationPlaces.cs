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

        }
    }
}
