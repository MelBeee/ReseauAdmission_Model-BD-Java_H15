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

        public Representation(OracleConnection oraconn)
        {
            InitializeComponent();
            oraconnPrincipale = oraconn;
        }

        private void Representation_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void BTN_AjouterHeureSalle_Click(object sender, EventArgs e)
        {

        }

        private void BTN_AjouterSectionPrix_Click(object sender, EventArgs e)
        {

        }
    }
}
