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


        public Representation(OracleConnection oraconn)
        {
            InitializeComponent();
            oraconnPrincipale = oraconn;
        }

        private void Representation_Load(object sender, EventArgs e)
        {

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

        }

        private void BTN_AjouterSectionPrix_Click(object sender, EventArgs e)
        {

        }
    }
}
