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
    public partial class TopAcheteur : Form
    {
        // variable contenant la connection a la bd 
        OracleConnection oraconnPrincipale = new OracleConnection();

        public TopAcheteur(OracleConnection connection)
        {
            InitializeComponent();
            oraconnPrincipale = connection;

            var pos = this.PointToScreen(label1.Location);
            pos = pictureBox1.PointToClient(pos);
            label1.Parent = pictureBox1;
            label1.Location = pos;
            label1.BackColor = Color.Transparent;

            var pos2 = this.PointToScreen(label2.Location);
            pos2 = pictureBox1.PointToClient(pos2);
            label2.Parent = pictureBox1;
            label2.Location = pos2;
            label2.BackColor = Color.Transparent;

            var pos3 = this.PointToScreen(label3.Location);
            pos3 = pictureBox1.PointToClient(pos3);
            label3.Parent = pictureBox1;
            label3.Location = pos3;
            label3.BackColor = Color.Transparent;
        }

        private void BTN_Fermer_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void TopAcheteur_Load(object sender, EventArgs e)
        {

        }
    }
}
