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

            var pos = this.PointToScreen(label1.Location);
            pos = pictureBox1.PointToClient(pos);
            label1.Parent = pictureBox1;
            label1.Location = pos;
            label1.BackColor = Color.Transparent;

            var pos2 = this.PointToScreen(LB_Bronze_Nom.Location);
            pos2 = pictureBox1.PointToClient(pos2);
            LB_Bronze_Nom.Parent = pictureBox1;
            LB_Bronze_Nom.Location = pos2;
            LB_Bronze_Nom.BackColor = Color.Transparent;

            var pos3 = this.PointToScreen(LB_Silver_Nom.Location);
            pos3 = pictureBox1.PointToClient(pos3);
            LB_Silver_Nom.Parent = pictureBox1;
            LB_Silver_Nom.Location = pos3;
            LB_Silver_Nom.BackColor = Color.Transparent;
        }

        private void BTN_Fermer_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void TopVentes_Load(object sender, EventArgs e)
        {

        }

        private void PB_Bronze_Image_Click(object sender, EventArgs e)
        {

        }

        private void PB_Gold_Image_Click(object sender, EventArgs e)
        {

        }

        private void PB_Silver_Image_Click(object sender, EventArgs e)
        {

        }

        private void LB_Bronze_Nombre_Click(object sender, EventArgs e)
        {

        }

        private void LB_Gold_Nombre_Click(object sender, EventArgs e)
        {

        }

        private void LB_Silver_Nombre_Click(object sender, EventArgs e)
        {

        }

        private void LB_Silver_Nom_Click(object sender, EventArgs e)
        {

        }

        private void LB_Bronze_Nom_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void LB_Gold_Nom_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
    }
}
